package com.hx.adpter;

import com.hx.lock.reentrantlock.RangerCacheService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LockController {

    @Resource
    RangerCacheService rangerCacheService;

    @GetMapping("trylock")
    public void lockTest() throws InterruptedException {
        rangerCacheService.check();
    }

    @GetMapping("trylock1")
    public void lockTest1() throws InterruptedException {
        rangerCacheService.check();
    }
}
