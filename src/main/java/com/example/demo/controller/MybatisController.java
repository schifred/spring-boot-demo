package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.dao.entity.User;
import com.example.demo.exception.Result;
import com.example.demo.service.MybatisService;
import com.example.demo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/mybatis")
public class MybatisController {
    @Autowired
    private MybatisService service;

    @GetMapping("/users/{id}")
    public Result getUser(@PathVariable("id") Integer id){
        System.out.print(id);
        User user = service.getUser(id);
        System.out.print(JSON.toJSONString(user));
        return ResultUtil.success(user);
    }

    @PostMapping("/users")
    public void createUser(@RequestBody Map<String, Object> reqMap){
        service.createUser(reqMap);
    }

    @PutMapping("/users/{id}")
    public void updateUser(@PathVariable("id") Integer id, @RequestParam("nickName") String nickName){
        service.updateUser(id, nickName);
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable("id") Integer id){
        service.delete(id);
    }
}
