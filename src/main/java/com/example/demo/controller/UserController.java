package com.example.demo.controller;

import com.example.demo.consts.Result;
import com.example.demo.dto.User;
import com.example.demo.utils.ResultUtil;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@RestController
@RequestMapping("/user")
@Validated
public class UserController extends BaseController {
    @GetMapping("/getUser")
    public Result getUser(
            @Pattern(regexp="^[1-9][0-9]*$",message="请输入正整数")
            @RequestParam(name = "id", required = true) String id){
        return ResultUtil.success(id);
    }

    @PostMapping("/createUser")
    public Result createUser(@Valid User user, BindingResult result){
        if (result.hasErrors()) {
            ResultUtil.error(400, result.getAllErrors().get(0).getDefaultMessage());
        }
        return ResultUtil.success(user);
    }

}
