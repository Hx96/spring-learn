package com.hx.ddd.infrastructure.util.jedis;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.junit.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class TestBloom {
    @Test
    public void testConnection() {
        RedisURI redisUri = RedisURI.builder()
                .withHost("127.0.0.1")
                .withPort(6379)
                .withTimeout(Duration.of(10, ChronoUnit.SECONDS))
                .build();
        RedisClient redisClient = RedisClient.create(redisUri);
        StatefulRedisConnection<String, String> connection = redisClient.connect();
        RedisCommands<String, String> commands = connection.sync();
        System.out.println(commands.ping());
        connection.close();
        redisClient.shutdown();
    }
}
