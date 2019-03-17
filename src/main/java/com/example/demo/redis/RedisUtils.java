package com.example.demo.redis;

public interface RedisUtils {
    /**
     * set存数据
     * @param key
     * @param value
     * @return
     */
    String set(String key, String value);

    /**
     * get获取数据
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 设置有效天数
     * @param key
     * @param expire
     * @return
     */
    Long expire(String key, Integer expire);

    /**
     * 移除数据
     * @param key
     * @return
     */
    Long del(String key);
}
