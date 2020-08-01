package com.example.demo.controller;

import com.example.demo.utils.RedisUtil;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/redis")
public class RedisController {
    @Resource
    RedisUtil redisUtil;

    @RequestMapping(value = "/set/{str}", method = RequestMethod.GET)
    public String set(@PathVariable("str") String str){
        return redisUtil.set("test", str);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String get(){
        return redisUtil.get("test");
    }
}
