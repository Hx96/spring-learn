package com.hx.lock.schedule;

import com.hx.lock.LockName;

public enum LockJob implements LockName {
    /**
     * 锁工作
     */
    LOCK_JOB_A("lockA", 100),
    LOCK_JOB_B("lockB", 100);
    private String lockName;
    private Integer lockTime;


    LockJob(String lockName, Integer lockTime) {
        this.lockName = lockName;
        this.lockTime = lockTime;
    }

    @Override
    public String getLockName() {
        return lockName;
    }

    @Override
    public Integer getLockTime() {
        return lockTime;
    }
}
