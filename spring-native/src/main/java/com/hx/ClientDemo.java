package com.hx;

import com.hx.map_auto.Animal;
import com.mzt.logapi.starter.annotation.EnableLogRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author kyle
 */
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class})
@RestController
@EnableLogRecord(tenant = "com.hx")
@ServletComponentScan(basePackages = "com.hx")
public class ClientDemo implements CommandLineRunner {

    @Resource
    public Map<String, Animal> animals;

    @Resource
    public List<Animal> animalsList;

    @Value("#{${spring.mysql.ip}}")
    private Map<String,String> map;


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
        System.out.println(animals);
        animalsList.forEach(Animal::say);
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
        System.out.println("map" + map.toString());
    }
}