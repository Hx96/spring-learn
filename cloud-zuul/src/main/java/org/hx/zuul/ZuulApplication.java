package org.hx.zuul;

import org.hx.zuul.config.MyApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author XingHuang
 */
@EnableEurekaClient
@EnableDiscoveryClient
//支持网关路由
@EnableZuulProxy
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableHystrix
public class ZuulApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = MyApplication.run(ZuulApplication.class, args);
        System.out.println(run.getBeanDefinitionCount());
    }
}
