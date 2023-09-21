package com.hx.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.stat.DruidDataSourceStatManager;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import javax.management.ObjectName;
import java.sql.DatabaseMetaData;
import java.util.Map;
import java.util.Set;

@Slf4j
//@Configuration
//@RequiredArgsConstructor
//@EnableTransactionManagement
public class FlyWayConfig {

//    private final DataSource dataSource;

    @Value("${spring.flyway.locations}")
    private String SQL_LOCATION;

    @Value("${spring.flyway.table}")
    private String VERSION_TABLE;

    @Value("${spring.flyway.baseline-on-migrate}")
    private boolean BASELINE_ON_MIGRATE;


    @Value("${spring.flyway.validate-on-migrate}")
    private boolean VALIDATE_ON_MIGRATE;

    @SneakyThrows
    @Bean
    @PostConstruct
    public void migrateOrder() {
        log.info("调用数据库生成工具");
        SQL_LOCATION = SQL_LOCATION.split("/")[0]; // 将路径转换
        Set<DruidDataSource> druidDataSourceInstances = DruidDataSourceStatManager.getDruidDataSourceInstances();
        Map<Object, ObjectName> instances = DruidDataSourceStatManager.getInstances();


        DruidDataSource next = druidDataSourceInstances.iterator().next();
        DatabaseMetaData metaData = next.getConnection().getMetaData();
        String driverName = metaData.getDriverName();
        Flyway flyway = Flyway.configure()
                .dataSource(next)
                .locations(SQL_LOCATION + "/" + "")
                .baselineOnMigrate(BASELINE_ON_MIGRATE)
                .table(VERSION_TABLE)
                .outOfOrder(false)
                .validateOnMigrate(VALIDATE_ON_MIGRATE)
                .load();
        flyway.migrate();
//        DynamicRoutingDataSource ds = (DynamicRoutingDataSource) dataSource;
//        Map<String, DataSource> dataSources = ds.getDataSources();
//        instances.forEach((k, v) -> {
//            log.info("正在执行多数据源生成数据库文件 " + k);
//            Flyway flyway = Flyway.configure()
//                    .dataSource(v)
//                    .locations(SQL_LOCATION + "/" + k)
//                    .baselineOnMigrate(BASELINE_ON_MIGRATE)
//                    .table(VERSION_TABLE)
//                    .outOfOrder(OUT_OF_ORDER)
//                    .validateOnMigrate(VALIDATE_ON_MIGRATE)
//                    .load();
//            flyway.migrate();
//        });
    }

}
