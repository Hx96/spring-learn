package com.hx.springcloud.config;

import com.netflix.eureka.DefaultEurekaServerConfig;
import com.netflix.eureka.EurekaServerConfig;
import org.springframework.beans.BeansException;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaServerStartedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

@Component
public class MyLifeCycle implements SmartLifecycle, ApplicationContextAware {

    private volatile boolean running = false;
    private ApplicationContext applicationContext;

    /**
     * SmartLifecycle子类的才有的方法，当isRunning方法返回true时，该方法才会被调用。
     * 很多框架中的源码中，都会把真正逻辑写在stop()方法内。
     * 比如quartz和Redis的spring支持包。
     */
    @Override
    public void stop(Runnable callback) {
    }

    /**
     * 1. 主要在该方法中启动任务或者其他异步服务，比如开启MQ接收消息<br/>
     * 2. 当上下文被刷新（所有对象已被实例化和初始化之后）时，将调用该方法，
     * 默认生命周期处理器将检查每个SmartLifecycle对象的isAutoStartup()方法返回的布尔值。
     * 如果为“true”，则该方法会被调用，而不是等待显式调用自己的start()方法。
     */
    @Override
    public void start() {
        applicationContext.publishEvent(new MyEvent("hello my event"));
        applicationContext.publishEvent(new EurekaServerStartedEvent(new DefaultEurekaServerConfig()));
        System.out.println("MySmartLifecycle容器启动完成 ...");
    }

    /**
     * 接口Lifecycle子类的方法，只有非SmartLifecycle的子类才会执行该方法。<br/>
     * 1. 该方法只对直接实现接口Lifecycle的类才起作用，对实现SmartLifecycle接口的类无效。<br/>
     * 2. 方法stop()和方法stop(Runnable callback)的区别只在于，后者是SmartLifecycle子类的专属。
     */
    @Override
    public void stop() {
    }

    /**
     * 1. 只有该方法返回false时，start方法才会被执行。<br/>
     * 2. 只有该方法返回true时，stop(Runnable callback)或stop()方法才会被执行。
     */
    @Override
    public boolean isRunning() {
        System.out.println("MySmartLifecycle检查运行状态 ...");
        return running;
    }

    /**
     * 如果有多个实现接口SmartLifecycle的类，则这些类的start的执行顺序按getPhase方法返回值从小到大执行。<br/>
     * 例如：1比2先执行，-1比0先执行。stop方法的执行顺序则相反，getPhase返回值较大类的stop方法先被调用，小的后被调用。
     *
     */
    @Override
    public int getPhase() {
        return 0;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
