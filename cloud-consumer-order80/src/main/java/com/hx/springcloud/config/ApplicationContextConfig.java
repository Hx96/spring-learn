package com.hx.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 配置
 * @author 35762
 */
@Configuration
public class ApplicationContextConfig {

  @Bean
  RestTemplate getRestTemplate(){
    return new RestTemplate();
  }
}
