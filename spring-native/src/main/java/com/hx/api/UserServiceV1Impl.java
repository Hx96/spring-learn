package com.hx.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
//@Qualifier("UserServiceV1Impl")
public class UserServiceV1Impl implements UserService {

    @Override
    @GetMapping("/v1/users")
    public void getUser(Integer id) {
        log.info("getUser V1 {}", id);
    }

    @Override
    @GetMapping("/v1/users/organizations")
    public void getOrganization(Integer id) {
        log.info("getOrganization V1 {}", id);

    }
}
