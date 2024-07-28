package org.hx.java.service;

import org.junit.Test;

import java.util.Objects;
import java.util.concurrent.*;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class ComputeFutureTest {
    public static final ExecutorService executor = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        Future<String> submitTask1 = executor.submit(() -> {
            Thread.sleep(1000);
            return "task1";
        });

        Future<String> submitTask2 = executor.submit(() -> {
            Thread.sleep(1000);
            return "task2";
        });

        String s = Stream.of(submitTask1, submitTask2).map(
                futureSingle -> {
                    try {
                        return futureSingle.get(10L, TimeUnit.MINUTES);
                    } catch (Exception e) {
                        return null;
                    }
                }
        ).filter(Objects::nonNull).sorted(String::compareTo).findFirst().get();

        long end = System.currentTimeMillis();

        System.out.println(s);
        System.out.println(end-start);
        executor.shutdown();
    }

    @Test
    public void test() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        System.out.println("x");
        CompletableFuture<String> stringCompletableFuture1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "task2";
        });

        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "task1";
        }).thenCombine(stringCompletableFuture1, new BiFunction<String, String, String>() {
            @Override
            public String apply(String s, String s2) {
                return s + " "+ s2;
            }
        });

        String s = stringCompletableFuture.get();
        System.out.println(s);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }


}
