package com.hx.ddd.infrastructure.util.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class TestCount {
    @Test
    public void name() {
        Jedis jedis = new Jedis("localhost",6379);
        for (int i = 0; i < 100000; i++) {
            jedis.pfadd("codehole", "user" + i);
        }
        long total = jedis.pfcount("codehole");
        System.out.printf("%d %d\n", 100000, total);
        jedis.close();
    }

    @Test
    public void voidTestBo() {
        Jedis jedis = new Jedis("localhost",6379);

    }
}
