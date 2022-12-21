package org.hx.java.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author XingHuang
 */
public class Client {
    public static void main(String[] args) {
        InterfaceMethod method;
        method = (something, some) -> System.out.println(something + some);
        method.say("33", "22");
        Map<Integer, Integer> map = new HashMap<>();

        String userId = "ttttttt";
        Optional.ofNullable(null);
        String test = Optional.ofNullable(userId).filter(s -> s.length() > 100).map(
                (s)->s.substring(0,2)
//        ).orElse(() -> new RuntimeException("tesat"));
        ).orElse("嗷嗷的");
        System.out.println(test);
    }


}
