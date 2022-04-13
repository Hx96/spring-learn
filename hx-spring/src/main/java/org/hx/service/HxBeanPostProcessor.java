package org.hx.service;

import org.hx.spring.BeanPostProcessor;
import org.hx.spring.Component;


/**
 * @author XingHuang
 */
@Component
public class HxBeanPostProcessor implements BeanPostProcessor {

    public static final String USER_SERVICE = "userService";

    @Override
    public void postProcessBeforeInitialization(String beanName, Object bean) {
        if (USER_SERVICE.equals(beanName)) {
            System.out.println("before do something" + beanName);
        }
    }

    @Override
    public void postProcessAfterInitialization(String beanName, Object bean) {
        if (USER_SERVICE.equals(beanName)) {
            System.out.println("after do something" + beanName);
        }
    }
}
