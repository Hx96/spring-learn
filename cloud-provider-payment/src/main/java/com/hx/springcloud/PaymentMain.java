package com.hx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @date 0717
 * @author hx
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentMain {

  public static void main(String[] args) {
    SpringApplication.run(PaymentMain.class);
  }
}
