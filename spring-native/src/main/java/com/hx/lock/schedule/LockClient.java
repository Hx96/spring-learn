package com.hx.lock.schedule;

public class LockClient {
    public static void main(String[] args) {
        DeleteScheduleJob deleteScheduleJob = new DeleteScheduleJob();
        deleteScheduleJob.schedule();
    }
}
