package org.hx.java.thread.safe;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * worker线程封装阻塞队列
 * @author kyle
 * @date 2023/01/24
 */
public class WorkerThread {

    public static void main(String[] args) {
        Helper helper = new Helper();
        helper.init();
        helper.submit("t1");
        helper.submit("t2");
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        helper.close();
    }

}

class Helper {
    private final BlockingQueue<String> workQueue = new ArrayBlockingQueue<>(1);

    private final Thread worker = new Thread(() -> {
        String task = null;
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                break;
            }
            try {
                task = workQueue.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(doProcess(task));
        }
    });

    private String doProcess(String task) {
        return task + " processed";
    }

    public void init() {
        worker.start();
    }

    public void close() {
        worker.interrupt();
    }

    public void submit(String task) {
        try {
            workQueue.put(task);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
