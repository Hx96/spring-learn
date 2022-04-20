package org.hx.zuul.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;

public class MyApplicationListener implements SpringApplicationRunListener {
    // Spring 容器实例化使用
    public MyApplicationListener(SpringApplication application, String[] args) {
    }
    @Override
    public void starting() {
        System.out.println("--started");
        SpringApplicationRunListener.super.starting();
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        System.out.println("--prepared");
        SpringApplicationRunListener.super.environmentPrepared(environment);
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        SpringApplicationRunListener.super.contextPrepared(context);
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        SpringApplicationRunListener.super.contextLoaded(context);
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        SpringApplicationRunListener.super.started(context);
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        System.out.println("--running");
        SpringApplicationRunListener.super.running(context);
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        SpringApplicationRunListener.super.failed(context, exception);
    }
}
