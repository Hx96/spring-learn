package org.hx.java.service;

/**
 * @author XingHuang
 */
public class Client {
    public static void main(String[] args) {
        InterfaceMethod method;
        method = (something, some) -> System.out.println(something + some);
        method.say("33", "22");
    }
}
