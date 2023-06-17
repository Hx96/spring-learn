package org.hx.java.lock.aqs;

import lombok.SneakyThrows;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyLockTest {

    @Test
    public void testMylock() throws InterruptedException {
        MyLock lock = new MyLock();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    lock.lock();
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "un");
//                    lock.unlock();
                }
            });
            t.start();
        }
        Thread.sleep(60000);
        System.out.println();
    }
}