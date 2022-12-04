package org.hx.java.thread.safe;

import java.util.Stack;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 可重入锁和条件使用
 *
 * 创建资源发送 信号
 * 资源满时等待await
 *
 * 消耗资源时发送信号
 * 没资源时await
 *
 * @author kyle
 * @date 2022/12/03
 */
class ReentrantLockWithConditionUse {

    Stack<String> stack = new Stack<>();
    int CAPACITY = 5;

    ReentrantLock lock = new ReentrantLock();
    Condition stackEmptyCondition = lock.newCondition();
    Condition stackFullCondition = lock.newCondition();

    public void pushToStack(String item) throws InterruptedException {
        try {
            lock.lock();
            while(stack.size() == CAPACITY) {
                stackFullCondition.await();
            }
            stack.push(item);
            stackEmptyCondition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public String popFromStack() throws InterruptedException {
        try {
            lock.lock();
            while(stack.size() == 0) {
                stackEmptyCondition.await();
            }
            return stack.pop();
        } finally {
            stackFullCondition.signalAll();
            lock.unlock();
        }
    }
}

public class ReentrantLockWithCondition {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("hello");
        ReentrantLockWithConditionUse reentrantLockWithConditionUse = new ReentrantLockWithConditionUse();
        reentrantLockWithConditionUse.pushToStack("xxxxxx");
        System.out.println(reentrantLockWithConditionUse.popFromStack());
        System.out.println(reentrantLockWithConditionUse.popFromStack());
    }
}
