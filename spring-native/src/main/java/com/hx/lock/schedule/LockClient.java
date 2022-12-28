package com.hx.lock.schedule;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockClient {

    public static final ConcurrentHashMap<String,String> lockVariables  = new ConcurrentHashMap<>();
    public static final Lock lock = new ReentrantLock();



    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 100, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100));
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.submit(() -> {

                sche();
            });
//            try {
//                Thread.sleep(11);
//            } catch (InterruptedException e) {
//
//
//            }
        }
        threadPoolExecutor.shutdown();
    }

    public static void sche() {
        DeleteScheduleJob deleteScheduleJob = new DeleteScheduleJob();
        deleteScheduleJob.schedule();
    }
}
