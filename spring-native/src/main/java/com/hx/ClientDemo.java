package com.hx;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * @author kyle
 */
@SpringBootApplication
@RestController
public class ClientDemo implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(ClientDemo.class, args);
        System.out.println("Hello world!");
    }


    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("Let's inspect the beans provided by Spring Boot:");
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            System.out.println(ctx);
            for (String beanName : beanNames) {
//                System.out.println(beanName);
            }
        };
    }

    @Resource
    private OrderService orderService;

    @Resource
    private ApplicationContext applicationContext;

    @Override
    public void run(String... args) throws Exception {
        SaveOrder saveOrder = new SaveOrder();
        saveOrder.setId(2222L);
        orderService.saveOrder(saveOrder);
        UpdateOrder updateOrder = new UpdateOrder();
        updateOrder.setOrderId(33333L);
        orderService.updateOrder(updateOrder);
        System.out.println(applicationContext);
    }
}