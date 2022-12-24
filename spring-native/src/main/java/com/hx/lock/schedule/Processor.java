package com.hx.lock.schedule;

/**
 * 处理
 *
 * @author kyle
 * @date 2022/12/23
 */
public interface Processor {
    /**
     * 处理
     *
     * @param args arg游戏
     */
    void process(Object... args);
}
