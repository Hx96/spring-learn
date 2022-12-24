package com.hx.lock;

/**
 * Redis分布式锁
 *
 * @author kyle
 * @date 2022/12/23
 */
public interface LockInRedis {
    /**
     * 试着锁
     *
     * @return boolean
     */
    boolean tryLock();

    /**
     * 联合国锁
     */
    void unLock();


    /**
     * 由当前线程
     *
     * @return boolean
     */
    boolean isHeldByCurrentThread();

    /**
     * 获取锁名字
     *
     * @return {@link String}
     */
    String getLockName();
}
