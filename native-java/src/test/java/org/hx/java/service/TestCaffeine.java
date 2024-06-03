package org.hx.java.service;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestCaffeine {

    /**
     * 手动加载cache
     */
    @Test
    public void testManualLoadCache2() throws InterruptedException {
        Cache<String, String> cache = Caffeine.newBuilder()
                .expireAfterWrite(5, TimeUnit.SECONDS) // 设置超时时间为5s / 写入后隔段时间过期
                .maximumSize(1)// 设置缓存最大条目数，超过条目则触发回收。
                .build();


        // 查找一个缓存元素， 没有查找到的时候返回null
        String value = cache.getIfPresent("test");
        System.out.println(value);//-->null
        // 查找缓存，如果缓存不存在则生成缓存元素,  如果无法生成则返回null
        value = cache.get("test", k -> "test-value");
        System.out.println(cache.getIfPresent("test"));//-->test-value
        System.out.println(value);//-->test-value


        // 加入一些缓存数据
        List<String> list = new ArrayList<>();
        for (int i = 2; i < 10; i++) {
            list.add("test" + i);
        }
        for (int i = 2; i < 10; i++) {
            // 添加或者更新一个缓存元素
            cache.put("test" + i, "test-value" + i);
        }

        // 执行缓存回收
        // 缓存的删除策略使用的是惰性删除和定时删除，但是我也可以自己调用cache.cleanUp()方法手动触发一次回收操作。cache.cleanUp()是一个同步方法。
        cache.cleanUp();

        //根据key list去获取一个map的缓存
        Map<String, String> dataObjectMap
                = cache.getAllPresent(list);
        //查看缓存中的数据
        System.out.println(dataObjectMap.size()); //--> 1
        System.out.println(dataObjectMap); //--> {test9=test-value9}

        Thread.sleep(5000); //设置10s的睡眠时间，使得超过过期时间

        System.out.println(cache.getIfPresent("test"));//-->null
    }

}
