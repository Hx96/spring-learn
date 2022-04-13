package org.hx.service;

import org.hx.spring.HxApplicationContext;

/**
 * @author XingHuang
 */
public class ClientApplication {
    public static void main(String[] args) {
        HxApplicationContext hxApplicationContext = new HxApplicationContext(AppConfig.class, ClientApplication.class);
        UserService userService = (UserService) hxApplicationContext.getBean("userService");
        userService.test();
        System.out.println(hxApplicationContext.getBean("orderService"));
    }
}
