package com.example.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.function.Function;

@Component
public class RedisUtil {
    @Autowired(required = false)
    private ShardedJedisPool shardedJedisPool;

    private <T> T excute(Function<ShardedJedis, T> func){
        ShardedJedis shardedJedis = shardedJedisPool.getResource();
        return func.apply(shardedJedis);
    }

    public String set(final String key, final String value) {
        return excute(e -> e.set(key, value));
    }

    public String get(final String key) {
        return excute(e -> e.get(key));
    }

    public Long expire(final String key, Integer expire) {
        return excute(e -> e.expire(key, expire));
    }

    public Long del(final String key) {
        return excute(e -> e.del(key));
    }
}
