package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
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
    @ConfigurationProperties(prefix = "spring.redis.pool")
    public JedisPoolConfig getJedisPoolConfig() {
        return new JedisPoolConfig();
    }

    @Bean
    public ShardedJedisPool shardedJedisPool(){
        // 连接池配置
        JedisPoolConfig jedisPoolConfig = getJedisPoolConfig();
        ArrayList<JedisShardInfo> arrayList = new ArrayList<>();
        JedisShardInfo redisShardInfo = new JedisShardInfo(host, port);
        redisShardInfo.setPassword(password);
        arrayList.add(redisShardInfo);
        // ShardedJedisPool 一般用于 redis 多实例部署，读写分离、主从模式等
        return new ShardedJedisPool(jedisPoolConfig, arrayList);
    }
}
