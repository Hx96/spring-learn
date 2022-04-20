package org.hx.java.service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author XingHuang
 */
public class Client {
    public static void main(String[] args) {
        InterfaceMethod method;
        method = (something, some) -> System.out.println(something + some);
        method.say("33", "22");
        Map<Integer, Integer> map = new HashMap<>();
    }
}
