package com.hx.lock.schedule;

import com.hx.lock.LocalScheduleLock;

public class DeleteScheduleJob implements SingleScheduleProcessor<DeleteScheduleLock>, Scheduler {

    private DeleteScheduleLock deleteScheduleLock = new DeleteScheduleLock(LockJob.LOCK_JOB_A);

    @Override
    public void process(Object... args) {
        System.out.println(Thread.currentThread().getName() + "开始调度");
        System.out.println("业务逻辑");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

            System.out.println(e);
        }
        System.out.println("结束");
    }

    @Override
    public void schedule() {
        process(deleteScheduleLock);
    }
}
