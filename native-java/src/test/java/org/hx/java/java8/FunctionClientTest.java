package org.hx.java.java8;

import lombok.SneakyThrows;
import org.hx.java.base.ListTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Consumer;

public class FunctionClientTest {
    // https://www.cnblogs.com/Chary/p/13821147.html

    private List<MapClientTest.Apple> apples;
    @FunctionalInterface
    interface Addtions {
        int test(int a, int b);// 我是核心
        default void hello() {
            System.out.println("我不会影响到函数式接口的定义");
        }
        static void hello1(){
            System.out.println("我也不会影响到函数式接口的定义");
        }
    }


    interface AddtionsCant {
        int test(int a, int b);// 我是核心
        default void hello() {
            System.out.println("我不会影响到函数式接口的定义");
        }
        static void hello1(){
            System.out.println("我也不会影响到函数式接口的定义");
        }
    }
    @Test
    public void name() {
        Addtions.hello1();
    }

    @Test
    public void testApple() {

    }

    @SneakyThrows
    @Test
    public void testThread() {
        System.out.println(Thread.currentThread().isDaemon());
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(10, 20, 10
                        , TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
        List<Future<?>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<?> submit = threadPoolExecutor.submit(() -> {
//                System.out.println(Thread.currentThread().isDaemon());
//                System.exit(1);
                List<ListTest.Apple> instance = ListTest.getInstance();
                System.out.println(instance);
            });
            futures.add(submit);
        }
        futures.forEach(future -> {
            try {
                future.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Test
    public void testNot() {
        ListTest.getInstance().stream();
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme