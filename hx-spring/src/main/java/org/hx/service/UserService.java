package org.hx.service;

import org.hx.spring.*;

/**
 * @author XingHuang
 */
@Component
@Scope("singleton")
public class UserService implements BeanNameAware, InitializeBean {
    @Autowired
    private OrderService orderService;

    private String beanName;



    void test() {
        System.out.println(orderService);
    }

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
        System.out.println(beanName);
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("do something");
    }
}
