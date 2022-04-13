package org.hx.service;


import org.hx.spring.HxApplicationContext;
import org.junit.jupiter.api.Test;

class ClientApplicationTest {

    @Test
    public void getBeanTest() {
        HxApplicationContext hxApplicationContext = new HxApplicationContext(AppConfig.class, ClientApplicationTest.class);
        UserService userService = (UserService) hxApplicationContext.getBean("userService");
        System.out.println(hxApplicationContext.getBean("orderService"));
        System.out.println(userService);
    }

}