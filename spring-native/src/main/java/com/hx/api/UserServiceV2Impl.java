package com.hx.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kyle
 * @date 2023/09/21
 */
@Slf4j
@RestController
//@Qualifier("UserServiceV2Impl")
public class UserServiceV2Impl implements UserServiceV2 {

    @Override
    @GetMapping("/v2/users")
    public void getUser(Integer id) {
        log.info("getUser V2 {}", id);
    }

    @Override
    @GetMapping("/v2/users/organizations")
    public void getOrganization(Integer id) {
        log.info("getOrganization V2 {}", id);

    }
}
