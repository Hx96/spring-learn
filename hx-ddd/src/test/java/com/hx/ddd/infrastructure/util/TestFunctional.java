package com.hx.ddd.infrastructure.util;

import org.junit.Test;

public class TestFunctional {


    @Test
    public void testRun() {
        int a = 5;
        Environments.execute(() -> System.out.println(a));
    }
}
