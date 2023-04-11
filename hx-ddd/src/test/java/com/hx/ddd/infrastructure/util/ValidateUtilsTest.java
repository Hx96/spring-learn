package com.hx.ddd.infrastructure.util;

import lombok.Data;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javax.validation.constraints.NotNull;

public class ValidateUtilsTest {

    private ExpectedException expectedException = ExpectedException.none();

    @Data
    class Apple {
        @NotNull(message = "参数不能为空")
        Integer id;
    }

    @Test
    public void testApple() {
        Apple apple = new Apple();
        Assert.assertThrows("测试", IllegalArgumentException.class, () -> ValidateUtils.validate(apple));
    }
}