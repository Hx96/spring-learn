package com.hx.lock;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.hx.lock.schedule.LockClient.lock;
import static com.hx.lock.schedule.LockClient.lockVariables;

/**
 * 当地安排锁
 *
 * @author kyle
 * @date 2022/12/23
 */
abstract public class LocalScheduleLock<T extends LockName> implements LockInRedis {


    T lockNameEnm;

    public LocalScheduleLock(T lockNameEnm) {
        this.lockNameEnm = lockNameEnm;
    }

    @Override
    public boolean tryLock() {
        lock.lock();
        try {
            String lockKey = lockNameEnm.getLockName();
            System.out.println(Thread.currentThread().getName() + " ***" + lockVariables + lock.hashCode());
            if (lockVariables.containsKey(lockKey)) {
                try {
                    System.out.println(Thread.currentThread().getName() + " 等待2s");
                    Thread.sleep(2000);
                    if (!lockVariables.containsKey(lockKey)) {
                        System.out.println(Thread.currentThread().getName() + " 获取锁");
                        return true;
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return false;
            }
            lockVariables.put(lockNameEnm.getLockName(), "xx");
            System.out.println(Thread.currentThread().getName() + " try: " + lockNameEnm.getLockName() + " time: " + lockNameEnm.getLockTime());
            return true;
        } finally {
            lock.unlock();
        }

    }

    @Override
    public void unLock() {
        lockVariables.remove(lockNameEnm.getLockName());
    }

    @Override
    public boolean isHeldByCurrentThread() {
        return lockVariables.containsKey(lockNameEnm.getLockName());
    }

    @Override
    public String getLockName() {
        return null;
    }
}
