package org.hx.java.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FunctionProgramTest {

    @Test
    public void testMain() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(5);
        numbers.add(1);
        Collections.sort(numbers, (n1, n2) -> n1.compareTo(n2));
        System.out.println(numbers);

        sum(numbers);
        Assert.assertEquals("9",sum(numbers).toString());

    }

    Integer sum(List<Integer> numbers) {
        return numbers.stream().collect(Collectors.summingInt(Integer::intValue));
    }

    @Test
    public void name() {
        Function<Double, Double> log = (value) -> Math.log(value);
        Function<Double, Double> sqrt = (value) -> Math.sqrt(value);
        Function<Double, Double> logThenSqrt = sqrt.compose(log);
        System.out.println(String.valueOf(logThenSqrt.apply(3.14)));


        System.out.println();
        // Output: 1.06
        Function<Double, Double> sqrtThenLog = sqrt.andThen(log);
        System.out.println("自定义" + Math.log(Math.sqrt(3.14)));
        System.out.println(String.valueOf(sqrtThenLog.apply(3.14)));
        // Output: 0.57
    }

    @Test
    public void testFunction() {
        Function<Integer, Integer> divide = (vInteger) -> divide2(vInteger);
        Function<Integer, Integer> divide4 = (vInteger) -> divide4(vInteger);
        Function<Integer, Integer> divide8 = divide.andThen(divide4);

        System.out.println(divide.compose(divide4).andThen(divide).apply(16));
        System.out.println(divide8.apply(8));
    }

    @Test
    public void testBiFunction() {
        BiFunction<Integer, Integer, Integer> deductBiFunction = (o, o2) -> o - o2;
        Function<Integer, Integer> plus10 = (o) -> o + 10;
        // 5-10+10=5
        Assert.assertEquals("5", deductBiFunction.andThen(plus10).apply(5, 10).toString());
    }

    @Test
    public void testPredicate() {
        Predicate<Number> more2 = this::more2;
        Predicate<Number> more4 = this::more4;
        System.out.println(more2.or(more4).test(3.5));

    }
    public <T extends Number> boolean more2(T v) {
        return v.intValue() > 2;
    }
    public <T extends Number >boolean more4(T v) {
        return v.intValue() > 4;
    }

    public Integer divide2(Integer dd) {
        return dd/2;
    }

    public Integer divide4(Integer dd) {
        return dd/4;
    }

    @Test
    public void testOptional() {
        System.out.println(Optional.of(2).flatMap(f -> Optional.of(3)));

        System.out.println(Optional.of(3).flatMap(f -> Optional.of(3 + f)
                .flatMap(s -> Optional.of(f + s + 3))
                .flatMap(x -> Optional.of(x + x + f))
                .flatMap(y -> Optional.of(y+y+f))
        ).orElse(2))
        ;
        System.out.println(Optional.of(2).flatMap(f -> Optional.of(3).flatMap(s -> Optional.of(f + s))));
    }


    @Test
    public void testCur() {
        Function<Double, Function<Double, Double>> weight = mass -> gravity -> mass * gravity;

        Function<Double, Double> weightOnEarth = weight.apply(9.81);
        System.out.println("My weight on Earth: " + weightOnEarth.apply(60.0));

        Function<Double, Double> weightOnMars = weight.apply(3.75);
        System.out.println("My weight on Mars: " + weightOnMars.apply(60.0));
    }

    @Test
    public void testOnEarth() {
        System.out.println(weightOnEarth().apply(60.0));
    }

    private static Function<Double, Double> weightOnEarth() {
        final double gravity = 9.81;
        return mass -> mass * gravity;
    }

}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme