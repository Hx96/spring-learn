package com.hx.springcloud;

import com.hx.springcloud.config.MyEvent;
import com.hx.springcloud.config.MyListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * eureka 相互注册
 *
 * @author 35762
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7002 {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(EurekaMain7002.class);
    }
}
