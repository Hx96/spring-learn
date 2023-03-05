package com.hx.inter;

import com.alibaba.ttl.TransmittableThreadLocal;

public class RegionIsolationHolder implements AutoCloseable {
    public static final TransmittableThreadLocal<Long> ISOLATION_THREAD_LOCAL = new TransmittableThreadLocal<>();

    public static Long get() {
        return ISOLATION_THREAD_LOCAL.get();
    }

    public static void set(Long region) {
        ISOLATION_THREAD_LOCAL.set(region);
    }

    public static void remove() {
        ISOLATION_THREAD_LOCAL.remove();
    }

    @Override
    public void close() {
        remove();
    }
}
