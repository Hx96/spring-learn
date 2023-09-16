package com.hx.ddd.infrastructure.util.jedis;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Assert;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class jedisTest {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class User implements Serializable {
        private String id;
        private String name;
        private Integer age;

    }

    @Test
    public void name() {
        Jedis jedis = new Jedis("localhost",6379);
        User hx = new User("1", "hx", 27);

        // set
        jedis.set("test", JSON.toJSONString(hx));

        // get
        String name = jedis.get("test");
        User user = JSON.parseObject(name, User.class);

        Assert.assertEquals(user.getName(), "hx");
        System.out.println(name);
        jedis.close();
    }

    @Test
    public void testRe() {
        Jedis jedis = new Jedis("localhost",6379);
        RedisWithReentrantLock redis = new RedisWithReentrantLock(jedis);
        System.out.println(redis.lock("codehole"));
        System.out.println(redis.lock("codehole"));
        System.out.println(redis.unlock("codehole"));
        System.out.println(redis.unlock("codehole"));
        System.out.println(redis.unlock("codehole"));
    }

    public static class RedisWithReentrantLock {
        private ThreadLocal<Map> lockers = new ThreadLocal<>();
        private Jedis jedis;

        public RedisWithReentrantLock(Jedis jedis) {
            this.jedis = jedis;
        }

        private boolean _lock(String key) {
            return jedis.set(key, "nx") != null;
        }

        private void _unlock(String key) {
            jedis.del(key);
        }

        private Map<String, Integer> currentLockers() {
            Map<String, Integer> refs = lockers.get();
            if (refs != null) {
                return refs;
            }
            lockers.set(new HashMap<>());
            return lockers.get();
        }

        public boolean lock(String key) {
            Map refs = currentLockers();
            Integer refCnt = (Integer) refs.get(key);
            if (refCnt != null) {
                refs.put(key, refCnt + 1);
                return true;
            }
            boolean ok = this._lock(key);
            if (!ok) {
                return false;
            }
            refs.put(key, 1);
            return true;
        }

        public boolean unlock(String key) {
            Map refs = currentLockers();
            Integer refCnt = (Integer) refs.get(key);
            if (refCnt == null) {
                return false;
            }
            refCnt -= 1;
            if (refCnt > 0) {
                refs.put(key, refCnt);
            } else {
                refs.remove(key);
                this._unlock(key);
            }
            return true;
        }
    }
}
