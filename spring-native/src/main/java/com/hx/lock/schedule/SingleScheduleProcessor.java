package com.hx.lock.schedule;

import com.hx.lock.LocalScheduleLock;
import com.hx.lock.LockInRedis;

/**
 * 单实例调度
 *
 * @author kyle
 * @date 2022/12/23
 */
public interface SingleScheduleProcessor<L extends LocalScheduleLock> extends Processor {

    /**
     * 过程
     * 默认处理方法
     *
     * @param lock 锁
     * @param args arg游戏
     */
    default void process(L lock, Object... args) {
        System.out.println("defaut");
        try {
            if (lock.tryLock()) {
                process(args);
            } else {
                System.out.println(Thread.currentThread().getName() + " get lock failed");
            }
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unLock();
            }
        }
    }
}
