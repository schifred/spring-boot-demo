package com.example.demo.controller;

import com.example.demo.consts.Result;
import com.example.demo.dto.UserDTO;
import com.example.demo.utils.ResultUtil;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/request")
@RestController
public class RequestController extends BaseController {
    @RequestMapping(value = "/pathVariableTest/{id}")
    public Result pathVariableTest(@PathVariable int id){
        return ResultUtil.success(id);
    }

    @RequestMapping(value = "/requestParamTest")
    public Result requestParamTest(@RequestParam(value = "id") int id){
        return ResultUtil.success(id);
    }

    @RequestMapping(value = "/requestBodyTest", method = RequestMethod.POST)
    public Result requestBodyTest(@RequestBody UserDTO user){

        return ResultUtil.success(user);
    }

    @RequestMapping(value = "/modelAttributeTest", method = RequestMethod.POST)
    public Result modelAttributeTest(@ModelAttribute UserDTO user){

        return ResultUtil.success(user);
    }

    @RequestMapping(value = "httpServletRequestTest", method = RequestMethod.POST)
    public Result httpServletRequestTest(HttpServletRequest request){

        return ResultUtil.success(request);
    }
}