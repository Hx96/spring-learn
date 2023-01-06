package org.hx.java.java8;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.hx.java.base.ListTest;
import org.junit.Test;
import org.slf4j.helpers.MessageFormatter;
import org.springframework.util.StringUtils;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Slf4j
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
        Map<Integer, ListTest.Apple> collect =
                ListTest.getInstance().stream()
                        .collect(Collectors
                                .toMap(ListTest.Apple::getId
                                        , Function.identity()
                                        , (key1, key2) -> key2));
        System.out.println(collect);
    }

    @Test
    public void testStream2Map() {
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        Map<String, Integer> map = stream.collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println(map);
        System.out.println(ListTest.getInstance().stream());
        Stream<ListTest.Apple> stream1 = ListTest.getInstance().stream();
        System.out.println(stream1);
    }

    @Test
    public void optionalTest() {
        List<String> list= new ArrayList<>();
        list.add(null);
        list.stream().findFirst().orElseThrow(()->new RuntimeException("xxx"));

        Optional.ofNullable(null).orElseThrow(()->new RuntimeException("xxx"));
        Optional.of(null).orElseThrow(()->new RuntimeException("xxx"));
    }

    @Test
    public void testFormat() {
        System.out.println(format("tetet{},float{},int{}", "sdsd",2.6,1));
        log.error("xxxx{}", "xx");
    }

    public String format(String format, Object ... args) {
        return MessageFormatter.arrayFormat(format, args).getMessage();
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme