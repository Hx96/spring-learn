package org.hx.java.thread.safe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafety {

    public static void main(String[] args) throws InterruptedException {

        // Hackers code
        MyObject myObject = new MyObject();
        synchronized (myObject) {
            while (true) {
                // Indefinitely delay myObject
                Thread.sleep(Integer.MAX_VALUE);
            }
        }

//        ProcessingThread pt = new ProcessingThread();
//        Thread t1 = new Thread(pt, "t1");
//        t1.start();
//        Thread t2 = new Thread(pt, "t2");
//        t2.start();
//        //wait for threads to finish processing
//        t1.join();
//        t2.join();
//        System.out.println("Processing count="+pt.getCount());
    }

}

class MyObject {

    // Locks on the object's monitor
    public synchronized void doSomething() {
        // ...
    }
}

class ProcessingThread implements Runnable{
    private int count;

//    private Lock lock = new ReentrantLock();int

    private Object mutex=new Object();

    @Override
    public void run() {
//        lock.lock();
        for(int i=1; i < 5; i++){
            processSomething(i);
            synchronized (mutex) {
                count++;
            }
            System.out.println("count: [" + Thread.currentThread().getName() + "]:" + count);
        }
//        lock.unlock();
    }

    public int getCount() {
        return this.count;
    }

    private void processSomething(int i) {
        // processing some job
        try {
            Thread.sleep(i*50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}