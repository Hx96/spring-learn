package org.hx.service;

import org.hx.spring.BeanPostProcessor;
import org.hx.spring.Component;


/**
 * @author XingHuang
 */
@Component
public class ZyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public void postProcessBeforeInitialization(String beanName, Object bean) {
//        System.out.println("Zy before do something");
//        System.out.println(beanName);
    }

    @Override
    public void postProcessAfterInitialization(String beanName, Object bean) {
//        System.out.println("Zy after do something");
    }
}
