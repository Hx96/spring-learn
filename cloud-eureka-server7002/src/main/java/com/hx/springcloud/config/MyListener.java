package com.hx.springcloud.config;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyListener implements ApplicationListener<MyEvent> {

    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.println(event);
        System.out.println(event.getSource().toString());
    }

    @EventListener
    public void myListener(Object o){
        System.out.println(o.toString());
    }
}
