package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;

@Configuration
public class RedisConfig {
    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private Integer port;

    @Value("${spring.redis.password}")
    private String password;

    @Bean
    public ShardedJedisPool shardedJedisPool(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMinIdle(100);
        jedisPoolConfig.setMaxIdle(1000);
        jedisPoolConfig.setMaxTotal(10000);
        ArrayList<JedisShardInfo> arrayList = new ArrayList<>();
        JedisShardInfo redisShardInfo = new JedisShardInfo(host, port);
        redisShardInfo.setPassword(password);
        arrayList.add(redisShardInfo);
        return new ShardedJedisPool(jedisPoolConfig, arrayList);
    }
}
