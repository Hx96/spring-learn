package com.hx.inter;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.util.TablesNamesFinder;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.stereotype.Component;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

/**
 * @author kyle
 */
@Slf4j
@Intercepts({
        @Signature(method = "prepare", type = StatementHandler.class, args = {Connection.class, Integer.class})
})
@Component
public class IsolationInterceptor implements Interceptor {
    /**
     * 逻辑表
     */
    @Getter
    @Setter
    private String[] logicTables;

    private static final String TABLE_NAME_SPLITTER = "_";

    private static final String PROPERTY_SPLITTER = ",";

//    private static final Map<SystemOriginEnum, String[]> SYSTEM_ORIGIN_MAP = new ConcurrentHashMap<>(200);

    private static final Map<String, String> TRANS_MAP = new ConcurrentHashMap<>(200);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        if (invocation.getTarget() instanceof StatementHandler) {
            StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
            MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
            MappedStatement mappedStatement = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
            BoundSql boundSql = statementHandler.getBoundSql();
            //获取SQL
            String sql = boundSql.getSql();

            Field field = boundSql.getClass().getDeclaredField("sql");
            field.setAccessible(true);
            field.set(boundSql, transSql(sql));
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        processProperty(properties);
    }

    @SneakyThrows
    private void processProperty(Properties properties) {
        try {
            BeanInfo info = Introspector.getBeanInfo(this.getClass(), Object.class);
            PropertyDescriptor[] propertyDescriptors = info.getPropertyDescriptors();
            Stream.of(propertyDescriptors).filter(desc -> !StringUtils.equals("properties", desc.getName())).forEach(desc -> {
                String value = properties.getProperty(desc.getName());
                if (StringUtils.isNotBlank(value)) {
                    try {
                        String[] strings = parsePropertyValue(value);
                        desc.getWriteMethod().invoke(this, new Object[]{strings});
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        try {
                            throw new IsolationException(ErrorCodeEnum.PROPERTY_ILLEGAL, e);
                        } catch (IsolationException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            });
        } catch (IntrospectionException e) {
            throw new IsolationException(ErrorCodeEnum.PROPERTY_ILLEGAL);
        }
    }

    private String[] parsePropertyValue(String value) {
        return Stream.of(value.split(PROPERTY_SPLITTER)).map(StringUtils::trim).toArray(String[]::new);
    }

    private String[] getPhysicalTables() {
        Long region = getRegion();
        return Stream.of(logicTables).map(s -> concat(s, region)).toArray(String[]::new);
    }

    /**
     * 获取租户
     *
     * @return
     */
    @SneakyThrows
    private Long getRegion() {
        Long region = RegionIsolationHolder.get();
        Optional.ofNullable(region).orElseThrow(() -> new IsolationException(ErrorCodeEnum.REGION_INVALID));
        return region;
    }

    public String concat(String source, Long region) {
        if (Objects.isNull(region)) {
            return source;
        }
        return new StringBuilder(source).append(TABLE_NAME_SPLITTER).append(region).toString();
    }

    /**
     * 替换表名
     *
     * @param sql
     * @return
     */
    private String transSql(String sql) {
        //todo 可加缓存
        return StringUtils.replaceEach(sql, logicTables, getPhysicalTables());
    }


    /**
     * 可以加入一些获取表名的相关操作，如缓存，提前解析等
     *
     * @param sql
     * @return
     * @throws JSQLParserException
     */
    private static Set<String> parseStatement(String sql) throws JSQLParserException {
       /* List<SQLStatement> stmtList = SQLUtils.parseStatements(sql, JdbcConstants.MYSQL);
        return stmtList.stream().map(stmt->{
            MySqlSchemaStatVisitor visitor = new MySqlSchemaStatVisitor();
            stmt.accept(visitor);
            return visitor.getCurrentTable();
        }).collect(Collectors.toSet());*/
        return new HashSet<>(getTableList(getStatement(sql)));
    }

    private static Statement getStatement(String sql) throws JSQLParserException {
        return CCJSqlParserUtil.parse(new StringReader(sql));
    }

    private static List<String> getTableList(Statement statement) {
        TablesNamesFinder tablesNamesFinder = new TablesNamesFinder();
        return tablesNamesFinder.getTableList(statement);
    }



}
