package com.hx.ddd.infrastructure;

import org.springframework.context.annotation.Configuration;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置
 *
 * @author kyle
 * @date 2023/03/26
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addWebRequestInterceptor(new WebRequestInterceptor() {
            @Override
            public void preHandle(WebRequest request) throws Exception {
                System.out.printf("hahahaha-------pre");
            }

            @Override
            public void postHandle(WebRequest request, ModelMap model) throws Exception {

            }

            @Override
            public void afterCompletion(WebRequest request, Exception ex) throws Exception {
                System.out.println("hihhhhhhh" + ex);
            }
        }).addPathPatterns("/**");
    }
}
