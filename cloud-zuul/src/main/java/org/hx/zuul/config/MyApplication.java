package org.hx.zuul.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class MyApplication extends SpringApplication {
    @Override
    protected void afterRefresh(ConfigurableApplicationContext context, ApplicationArguments args) {
        System.out.println("after refresh");
        super.afterRefresh(context, args);
    }



    public void ConfigurableApplicationContext ConfigurableApplicationContext run(Class<?>[] primarySources, String[] args) {
        return new SpringApplication(primarySources).run(args);
    }

    @Override
    public ConfigurableApplicationContext run(Class<?>[] primarySources, String[] args) {
        return super.run(args);
    }
}
