package com.hx.ddd.adpter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 哨兵控制器
 *
 * @author kyle
 * @date 2023/05/02
 */
@RestController
public class SentinelController {

    @Value("#{workersHolder.salaryByWorkers['John']}") // 35000
    private Integer johnSalary;

    @Value("#{workersHolder.salaryByWorkers['George']}") // 14000
    private Integer georgeSalary;

    @Value("#{workersHolder.salaryByWorkers['Susie']}") // 47000
    private Integer susieSalary;

    @Value("#{workersHolder.workers[0]}") // John
    private String firstWorker;

    @Value("#{workersHolder.workers[3]}") // George
    private String lastWorker;

    @Value("#{workersHolder.workers.size()}") // 4
    private Integer numberOfWorkers;

    @GetMapping("/sayHello")
    public String sayHello() throws InterruptedException {
        return "hello";
    }
}
