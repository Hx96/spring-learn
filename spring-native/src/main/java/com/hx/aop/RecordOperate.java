package com.hx.aop;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author kyle
 */
@Retention(RUNTIME)
public @interface RecordOperate {

    String desc() default "";

    Class<? extends Convert> convert() default Convert.class;

    int argsOrder() default Integer.MAX_VALUE;
}
