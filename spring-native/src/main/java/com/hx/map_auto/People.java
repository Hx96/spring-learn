package com.hx.map_auto;

import org.springframework.stereotype.Component;

@Component
public class People implements Animal {
    @Override
    public void say() {
        System.out.println("hello");
    }
}
