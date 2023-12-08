package com.hx.ddd.infrastructure.util;

public class StackTest {

        public static void main(String[] args) {
            new Thread(() -> {
                dome();
            }, "wei").start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            dome();

        }
        static  void   dome() {
            dome2();
        }
        static  int dome2() {
            return 0;
        }
}
