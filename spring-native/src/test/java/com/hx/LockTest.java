package com.hx;

import lombok.SneakyThrows;
import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    private ReentrantLock lock = new ReentrantLock();
    @Test
    public void name() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    lock.lock();
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "un");
                    lock.unlock();
                }
            });
            t.start();
        }
        Thread.sleep(60000);
        System.out.println();
    }
}
