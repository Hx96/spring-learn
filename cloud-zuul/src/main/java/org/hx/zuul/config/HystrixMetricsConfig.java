package org.hx.zuul.config;

import com.soundcloud.prometheus.hystrix.HystrixPrometheusMetricsPublisher;
import io.prometheus.client.CollectorRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class HystrixMetricsConfig {
    @Autowired
    private CollectorRegistry registry;

    /**
     * 将hystrix.stream格式转换成prometheus metrics格式
     */
    @PostConstruct
    public void init() {
        HystrixPrometheusMetricsPublisher.builder().withRegistry(registry).buildAndRegister();
    }
}
