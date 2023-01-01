package org.hx.java.base;

import org.hx.java.java8.MapClientTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 测试列表
 *
 * @author kyle
 * @date 2023/01/01
 */
public class ListTest {

    public ListTest() {
    }

    public static class Apple {
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
    }

    private static volatile List<Apple> apple;

    public static List<Apple> getInstance() {
        if (Objects.isNull(apple)) {
            synchronized (ListTest.class) {
                if (Objects.isNull(apple)) {
                    List<Apple> appleList = new ArrayList<>();//存放apple对象集合
                    Apple apple1 =  new Apple(1,"苹果1",new BigDecimal("3.25"),10);
                    Apple apple12 = new Apple(1,"苹果2",new BigDecimal("1.35"),20);
                    Apple apple2 =  new Apple(2,"香蕉",new BigDecimal("2.89"),30);
                    Apple apple3 =  new Apple(3,"荔枝",new BigDecimal("9.99"),40);
                    appleList.add(apple1);
                    appleList.add(apple12);
                    appleList.add(apple2);
                    appleList.add(apple3);
                    apple = appleList;
                }
            }
        }
        return apple;
    }
}
