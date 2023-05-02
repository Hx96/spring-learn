package com.hx.ddd.adpter;

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

    @GetMapping("/sayHello")
    public String sayHello() throws InterruptedException {
        return "hello";
    }
}
