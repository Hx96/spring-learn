package com.hx.lock.reentrantlock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 骑警缓存服务
 *
 * @author kyle
 * @date 2023/05/20
 */
@Component
@Slf4j
public class RangerCacheService {

    private ReentrantLock lock = new ReentrantLock();

    public void refreshAllPolicy() throws InterruptedException {
        lock.lock();
        log.error("lockgeshu {}", lock.getHoldCount());
        log.error(Thread.currentThread().getName() + "zhixinggengxing");
        Thread.sleep(2000);
        lock.unlock();
        log.error(Thread.currentThread().getName() + "wan cheng ye wu ");
        log.error("lockgeshuyewu {}", lock.getHoldCount());
    }

    public void check() throws InterruptedException {
        log.error(Thread.currentThread().getName()+"dengdai");
        lock.lock();

        refreshAllPolicy();

        lock.unlock();

    }
}
