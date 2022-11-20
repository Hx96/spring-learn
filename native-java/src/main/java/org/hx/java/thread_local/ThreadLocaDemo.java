package org.hx.java.thread_local;

public class ThreadLocaDemo {

    private static ThreadLocal<String> localVar = new ThreadLocal<String>();
    private static ThreadLocal<String> localVar1 = new ThreadLocal<String>();

    static void print(String str) {
        //打印当前线程中本地内存中本地变量的值
        System.out.println(str + " :" + localVar.get());
        //清除本地内存中的本地变量
        localVar.remove();
    }
    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            public void run() {
                ThreadLocaDemo.localVar.set("local_A");
                print("A");
                //打印本地变量
                System.out.println("after remove : " + localVar.get());
                localVar1.set("xxxxxxx");
                System.out.println(localVar1.get());

            }
        },"A").start();

        Thread.sleep(1000);

        new Thread(new Runnable() {
            public void run() {
                ThreadLocaDemo.localVar.set("local_B");
                print("B");
                System.out.println("after remove : " + localVar.get());

            }
        },"B").start();

        System.out.println("main: " + localVar1.get());
    }
}