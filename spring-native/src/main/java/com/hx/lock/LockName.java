package com.hx.lock;

/**
 * 锁名字
 *
 * @author kyle
 * @date 2022/12/24
 */
public interface LockName {
    /**
     * 获取锁名字
     *
     * @return {@link String}
     */
    String getLockName();

    Integer getLockTime();
}
