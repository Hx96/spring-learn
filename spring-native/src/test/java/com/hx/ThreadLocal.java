package com.hx;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadLocal {
    static TransmittableThreadLocal<String> transmittableThreadLocal = new TransmittableThreadLocal<>();

    @Test
    public void testThread() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        // 用TtlExecutors装饰线程池
        executorService = TtlExecutors.getTtlExecutorService(executorService);

        transmittableThreadLocal.set("i am a transmittable parent");
        executorService.execute((Runnable) () -> {

            System.out.println(transmittableThreadLocal.get());
            // 子线程设置新的值
            transmittableThreadLocal.set("i am a old transmittable parent");

        });
        System.out.println(transmittableThreadLocal.get());

        TimeUnit.SECONDS.sleep(1);
        // 主线程设置新的值
        transmittableThreadLocal.set("i am a new transmittable parent");
        executorService.execute((Runnable) () -> System.out.println(transmittableThreadLocal.get()));
    }
}
