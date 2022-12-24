package com.hx.lock.schedule;

import com.hx.lock.LocalScheduleLock;

public class DeleteScheduleJob implements SingleScheduleProcessor<DeleteScheduleLock>, Scheduler {

    private DeleteScheduleLock deleteScheduleLock = new DeleteScheduleLock();

    @Override
    public void process(Object... args) {
        System.out.println("业务逻辑");
    }

    @Override
    public void schedule() {
        process(deleteScheduleLock);
    }
}
