package com.hx.ddd.infrastructure.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ValidateUtilsTest {

    private ExpectedException expectedException = ExpectedException.none();

    @Data
    class Apple {
        @NotNull(message = "参数不能为空")
        Integer id;
    }

    @Test
    public void testApple() {
        Apple apple = new Apple();
        Assert.assertThrows("测试", IllegalArgumentException.class, () -> ValidateUtils.validate(apple));
    }


    @Data
    @AllArgsConstructor
    @ToString
    class User {
        private Integer id;
        private String name;
    }
    @Test
    public void testParameter() {
        User ls = new User(1, "ls");
        changeTest(ls);
        System.out.println(ls);
        ArrayList<Object> objects = new ArrayList<>();
        List<Object> collect = objects.stream().filter(new Predicate<Object>() {
            @Override
            public boolean test(Object o) {
                return false;
            }
        }).collect(Collectors.toList());
        objects.add("x");
        objects.sort(new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });
        CollectionUtils.addAll(new Collection() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public Object[] toArray(Object[] a) {
                return new Object[0];
            }

            @Override
            public boolean add(Object o) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection c) {
                return false;
            }

            @Override
            public boolean addAll(Collection c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection c) {
                return false;
            }

            @Override
            public void clear() {

            }
        }, new Iterator() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Object next() {
                return null;
            }
        });
    }

    private void changeTest(User ls) {
        ls.id = 5;
    }
}