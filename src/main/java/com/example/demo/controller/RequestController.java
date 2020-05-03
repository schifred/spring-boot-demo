package com.example.demo.controller;

import com.example.demo.exception.Result;
import com.example.demo.dao.entity.User;
import com.example.demo.utils.ResultUtil;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/request")
@RestController
public class RequestController {
    @RequestMapping(value = "/pathVariableTest/{id}")
    public Result pathVariableTest(@PathVariable int id){
        System.out.println(id);
        return ResultUtil.success();
    }

    @RequestMapping(value = "/requestParamTest")
    public Result requestParamTest(@RequestParam(value = "id") int id){
        System.out.println(id);
        return ResultUtil.success();
    }

    @RequestMapping(value = "/requestBodyTest", method = RequestMethod.POST)
    public Result requestBodyTest(@RequestBody User user){
        return ResultUtil.success(user);
    }

    @RequestMapping(value = "/modelAttributeTest", method = RequestMethod.POST)
    public Result modelAttributeTest(@ModelAttribute User user){
        return ResultUtil.success(user);
    }

    @RequestMapping(value = "httpServletRequestTest", method = RequestMethod.POST)
    public Result httpServletRequestTest(HttpServletRequest request){
        return ResultUtil.success(request);
    }
}