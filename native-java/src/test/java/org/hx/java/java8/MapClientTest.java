package org.hx.java.java8;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * 地图客户端测试
 * https://blog.csdn.net/lu930124/article/details/77595585
 * @author kyle
 * @date 2022/12/28
 */
public class MapClientTest {

    private List<Apple> apples;

    public MapClientTest() {
        List<Apple> appleList = new ArrayList<>();//存放apple对象集合

        Apple apple1 =  new Apple(1,"苹果1",new BigDecimal("3.25"),10);
        Apple apple12 = new Apple(1,"苹果2",new BigDecimal("1.35"),20);
        Apple apple2 =  new Apple(2,"香蕉",new BigDecimal("2.89"),30);
        Apple apple3 =  new Apple(3,"荔枝",new BigDecimal("9.99"),40);

        appleList.add(apple1);
        appleList.add(apple12);
        appleList.add(apple2);
        appleList.add(apple3);
        this.apples = appleList;
    }


    class Apple {
        private Integer id;
        private String name;
        private BigDecimal money;
        private Integer num;
        public Apple(Integer id, String name, BigDecimal money, Integer num) {
            this.id = id;
            this.name = name;
            this.money = money;
            this.num = num;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", money=" + money +
                    ", num=" + num +
                    '}';
        }

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public BigDecimal getMoney() {
            return money;
        }

        public Integer getNum() {
            return num;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setMoney(BigDecimal money) {
            this.money = money;
        }

        public void setNum(Integer num) {
            this.num = num;
        }
    }

    @Test
    public void testMain() {
        System.out.println(apples);
    }

    @Test
    public void testGroupingBy() {
        Map<Integer, List<Apple>> collect = apples.stream().collect(Collectors.groupingBy(Apple::getId));
        System.out.println(collect);
    }

    /**
     * 测试列表转换映射
     * param1 需要的key
     * param2 需要的value
     * param3 需要的key冲突value处理方式
     */
    @Test
    public void testListConvertMap() {
        Map<Integer, String> collect = apples.stream().collect(Collectors.toMap(Apple::getId, Apple::getName, (s, s2) -> s+s2));
        System.out.println(collect);
    }

    /**
     * 测试和
     */
    @Test
    public void testSum() {
        BigDecimal reduce = apples.stream().map(Apple::getMoney).reduce(new BigDecimal(20), BigDecimal::add);
        System.out.println(reduce);
        // 17.48
    }

    @Test
    public void testMaxAndMin() {
        Optional<Apple> max = apples.stream().max(Comparator.comparing(Apple::getMoney));
        max.ifPresent(System.out::println);
    }

    @Test
    public void testReduce() {
        int reduce = Arrays.stream(new int[]{5, 2, 8}).reduce(0, (a, b) -> a / b);
        System.out.println(reduce);
        Function<String, String> identity = Function.identity();
        String apply = identity.apply("222");
        System.out.println(apply);
    }

    @Test
    public void toMap() {
        Map<Integer, Apple> collect = apples.stream().collect(Collectors.toMap(Apple::getId, Function.identity(), (key1, key2) -> key1));
        System.out.println(collect);
    }

    static class TestFunc {
        public <T> T test(Supplier<T> supplier) {
            return supplier.get();
        }

        public static TestFunc build() {
            return new TestFunc();
        }
    }

    @Test
    public void testConvert() {
        final String testSSS = ":l";
        final List<Integer> list = new ArrayList<>();
        Apple apple2 =  new Apple(2,"香蕉",new BigDecimal("2.89"),30);
        int a = 555;
        String test = TestFunc.build().test(() -> {
            System.out.println("22");
            System.out.println(testSSS);
            list.add(2);
            System.out.println(apple2.getMoney());
            apple2.setId(1);
            System.out.println(a);
            return "11";
        });
        System.out.println(apple2);
        System.out.println(test);
        System.out.println(list);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme