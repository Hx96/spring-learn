package com.hx.lock;

/**
 * 当地安排锁
 *
 * @author kyle
 * @date 2022/12/23
 */
abstract public class LocalScheduleLock implements LockInRedis {

    @Override
    public boolean tryLock() {
        System.out.println("try");
        return true;
    }

    @Override
    public void unLock() {

    }

    @Override
    public boolean isHeldByCurrentThread() {
        return false;
    }

    @Override
    public String getLockName() {
        return null;
    }
}
