package org.hx.java.java8.thread;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 未来异步客户端测试
 * future get() 主线程会抛异常
 * future 出异常不会抛出
 *
 * 回调
 * 串行化 支持。。。拉姆达表达式
 * 异步组合
 * https://blog.csdn.net/qq_33524158/article/details/107243344
 * https://blog.51cto.com/u_15840568/5784200
 * @author kyle
 * @date 2023/01/01
 */
@Slf4j
public class FutureAsyncClientTest {
    @SneakyThrows
    @Test
    public void testFuture() {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(()->{
            System.out.println("带有返回值的异步任务");
            return "a future value";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(()->{
            System.out.println("带有返回值的异步任务");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            throw new RuntimeException("异步任务出异常了");
//            return "a future value2";
        });

        CompletableFuture<Object> objectCompletableFuture = future1.thenApply(new Function<String, Object>() {
            @Override
            public Object apply(String s) {
                return s + " xxxx";
            }
        });

        future2.whenComplete(new BiConsumer<String, Throwable>() {
            @Override
            public void accept(String s, Throwable throwable) {
                System.out.println(throwable.getMessage());
                System.out.println(s+" 回调");;
            }
        });
        CompletableFuture.allOf(future1, future2);
        String s = future1.get();
        Assert.assertEquals("a future value",s);
//        Assert.assertEquals("a future value2",future2.get());
        System.out.println(objectCompletableFuture.get());
        Thread.sleep(220);
    }

    @Test
    public void testSerial() {
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(() -> 2)
                .thenApply(num -> num * 6)
                .thenAccept(System.out::print);
    }

    @Test
    public void handelException() {
        CompletableFuture.supplyAsync(() -> 2)
                .thenApply(num -> num / 0)
                .thenApply(result -> result * 3)
                .handle((integer, throwable) -> {
                    if (throwable == null) {
                        return integer;
                    } else {
                        log.error("异常", throwable);
                        throwable.printStackTrace();
                        return -1;
                    }
                }).thenAccept(System.out::print);
    }

    @SneakyThrows
    @Test
    public void testThenCombine() {
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("任务1开始");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("任务1结束");
            return 2;
        });

        CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("任务2开始");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("任务2结束");
            return 3;
        });

        CompletableFuture<Integer> completableFuture = cf1.thenCombine(cf2, (result1, result2) -> result1 * result2);
        cf2.thenCombine(completableFuture, (result1, result2) -> result1 * result2)
                .thenAccept(System.out::println);
        System.out.println("计算结果:" + completableFuture.get());
    }

    @SneakyThrows
    @Test
    public void testStream() {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("任务1开始");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("任务1结束");
            return 2;
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            System.out.println("任务2开始");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("任务2结束");
            return 3;
        }), (result1, result2) -> result1 * result2);
        CompletableFuture<Void> voidCompletableFuture = completableFuture.thenAccept(System.out::println);
        System.out.println(voidCompletableFuture.get());
        System.out.println("计算结果:" + completableFuture.get());
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme