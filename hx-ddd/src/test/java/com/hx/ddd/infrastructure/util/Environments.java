package com.hx.ddd.infrastructure.util;

public class Environments {


    public static void setEnv() {
        System.out.println("setEnv");
    }


    public static void execute(Executable executable) {
        setEnv();
        executable.execute();
    }

    @FunctionalInterface
    interface Executable {
        public void execute();
    }
}
