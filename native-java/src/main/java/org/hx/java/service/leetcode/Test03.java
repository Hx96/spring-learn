//package org.hx.java.service.leetcode;
//
//import org.junit.Test;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.concurrent.TimeUnit;
//
///**
// * @author XingHuang
// */
//public class Test03 {
//
//    public static void main(String[] args) {
////        Phone phone = new Phone1();
////        Phone phone2 = new Phone1();
//
//        new Thread(Phone1::sendSms, "A").start();
//
//        new Thread(Phone1::call, "B").start();
//
//        try {
//            TimeUnit.SECONDS.sleep(6);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Test
//    public void testMap() {
//        String str = "23123";
//        for (int i = 0; i < str.length(); i++) {
//            System.out.println(str.charAt(i));
//        }
//        Map<Integer, Character> map = new HashMap<>();
//        map.containsValue("");
//    }
//
//    @Test
//    public void testInt() {
//        int[] nums1 = new int []{1 ,2 ,3};
//        int a = 1,b=2;
//        int c= a<b? a:b;
//        System.out.println(c);
//        System.out.println(nums1.length);
//    }
//
//    @Test
//    public void testAnno(){
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
//                "org.hx.java.service.leetcode");
////        ctx.scan();
////        ctx.refresh();
//        System.out.println(ctx.getBean("myLifeCycle"));
////        ctx.start();
////        ctx.close();
//    }
//}
//
//    /**
//     * 打印发短信
//     */
//    @Test
//    public void test1() {
//        Phone phone = new Phone();
//
//        new Thread(phone::sendSms, "A").start();
//
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        new Thread(phone::call, "B").start();
//    }
//
//    @Test
//    public void test2() {
//        Phone phone = new Phone();
//        Phone phone2 = new Phone();
//
//        new Thread(phone::sendSms, "A").start();
//
//        new Thread(phone2::call, "B").start();
//
//        try {
//            TimeUnit.SECONDS.sleep(6);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//
//}
//
//class Phone {
//    public synchronized void sendSms() {
//        try {
//            TimeUnit.SECONDS.sleep(4);
//        } catch (InterruptedException e) {
//            System.out.println("1");
//            throw new RuntimeException(e);
//        }
//        System.out.println("sendSms");
//    }
//
//    public synchronized void call() {
//        System.out.println("call");
//    }
//
//    public void hello() {
//        System.out.println("hello");
//    }
//}
//
//class Phone1 {
//    public static  void sendSms() {
//        synchronized(Phone1.class){
//            try {
//                TimeUnit.SECONDS.sleep(4);
//            } catch (InterruptedException e) {
//                System.out.println("1");
//                throw new RuntimeException(e);
//            }
//            System.out.println("sendSms");
//        }
//
//    }
//
//    public static void call() {
//        synchronized(Phone1.class){
//            System.out.println("call");
//        }
//    }
//
//    public void hello() {
//        System.out.println("hello");
//    }
//}