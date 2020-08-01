package com.example.demo.controller;

import com.example.demo.consts.Result;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import com.example.demo.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@RestController
@RequestMapping("/user")
@Validated
@Api(tags="用户信息")
public class UserController extends BaseController {
    @Resource
    UserService userService;

    @ApiOperation(value = "获取用户", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "id", required = true, paramType = "query")
    })
    @GetMapping("/getUser")
    public Result getUser(
            @Pattern(regexp="^[1-9][0-9]*$",message="请输入正整数")
            @RequestParam(name = "id", required = true) String id){
        UserDTO userDTO = userService.getUser(Long.valueOf(id));
        return ResultUtil.success(userDTO);
    }

    @ApiOperation(value = "创建用户", httpMethod = "POST")
    @PostMapping("/createUser")
    public Result createUser(@Valid UserDTO userDTO, BindingResult result){
        if (result.hasErrors()) {
            ResultUtil.error(400, result.getAllErrors().get(0).getDefaultMessage());
        }
        int i = userService.createUser(userDTO);
        return ResultUtil.success(i);
    }

    @ApiOperation(value = "更新用户", httpMethod = "POST")
    @PostMapping("/updateUser")
    public Result updateUser(@Valid UserDTO userDTO, BindingResult result){
        if (result.hasErrors()) {
            ResultUtil.error(400, result.getAllErrors().get(0).getDefaultMessage());
        }
        int i = userService.updateUser(userDTO);
        return ResultUtil.success(i);
    }

    @ApiOperation(value = "删除用户", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "id", required = true, paramType = "query")
    })
    @PostMapping("/deleteUser")
    public Result deleteUser(
        @Pattern(regexp="^[1-9][0-9]*$",message="请输入正整数")
        @RequestParam(name = "id", required = true) String id){
        int i = userService.delete(Long.valueOf(id));
        return ResultUtil.success(i);
    }

}
