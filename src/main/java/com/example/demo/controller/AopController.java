package com.example.demo.controller;

import com.example.demo.aop.Log;
import com.example.demo.exception.Result;
import com.example.demo.utils.ResultUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/aop")
public class AopController {
    @Log(log = "切面")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Result getTest(){
        return ResultUtil.success();
    }
}
