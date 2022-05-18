package org.hx.java.service.leetcode;

import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Component;

@Component
public class MyLifeCycle implements Lifecycle {
    @Override
    public void start() {
        System.out.println("start1");
    }
    @Override
    public boolean isRunning() {
        System.out.println("isRunning1");
        return false;
    }
    @Override
    public void stop() {
        System.out.println("stop1");
    }
}
