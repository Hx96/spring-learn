package com.hx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * order
 * @author 35762
 */
@SpringBootApplication
@EnableEurekaClient
public class OrderMain80 {
  public static void main(String[] args) {
    SpringApplication.run(OrderMain80.class);
  }
}
