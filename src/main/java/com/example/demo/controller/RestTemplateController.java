package com.example.demo.controller;

import com.example.demo.consts.Result;
import com.example.demo.dto.UserDTO;
import com.example.demo.utils.ResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/rest-template")
public class RestTemplateController extends BaseController {
    @Resource
    RestTemplate restTemplate;

    @GetMapping("/getUser")
    public Result getUser(@RequestParam(name = "id", required = true) String id){
        UserDTO userDTO = restTemplate.getForObject("http://localhost:8080/user/getUser?id=" + id, UserDTO.class);
        return ResultUtil.success(userDTO);
    }
}
