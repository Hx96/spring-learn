package com.hx.ddd.adpter;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixController {

    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("/xxx")
    User getUserById(String id) {
        throw new RuntimeException("getUserById command failed");
    }

    public User fallback(String id, Throwable throwable) {
        return new User("def", "def");
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class User {
        private String id;
        private String name;
    }

}
