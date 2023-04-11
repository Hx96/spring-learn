package com.hx.ddd.infrastructure.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * jsr3自定义校验
 *
 * @author kyle
 * @date 2023/04/09
 */
@Slf4j
public class ValidateUtils {

    /**
     * 验证器
     */
    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    /**
     * 使用指定分组
     *
     * @param object 被校验的bean
     * @param groups 分组
     * @return
     */
    public static <T> Map<String, StringBuilder> validate(T object, Class<?>... groups) {
        Map<String, StringBuilder> errorMap = new HashMap<>(16);
        if (groups == null) {
            groups = new Class[]{Default.class};
        }
        Set<ConstraintViolation<T>> set = validator.validate(object, groups);
        if (CollectionUtils.isEmpty(set)) {
            return null;
        }
        String property;
        for (ConstraintViolation<T> c : set) {
            // 这里循环获取错误信息，可以自定义格式
            property = c.getPropertyPath().toString();
            if (errorMap.get(property) != null) {
                errorMap.get(property).append(",").append(c.getMessage());
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(c.getMessage());
                errorMap.put(property, sb);
            }
        }
        if (!CollectionUtils.isEmpty(errorMap)) {
            log.info("------参数校验失败:{}", errorMap);
            throw new IllegalArgumentException("参数校验失败" +  errorMap);
        }
        return errorMap;
    }

}
