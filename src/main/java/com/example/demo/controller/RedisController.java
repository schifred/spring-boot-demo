package com.example.demo.controller;

import com.example.demo.redis.RedisUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/redis")
public class RedisController {
    @Resource
    RedisUtils redisUtils;

    @RequestMapping(value = "/set/{str}", method = RequestMethod.GET)
    public String set(@PathVariable("str") String str){
        return redisUtils.set("test", str);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String get(){
        return redisUtils.get("test");
    }
}
