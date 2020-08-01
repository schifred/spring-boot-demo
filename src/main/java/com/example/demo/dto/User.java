package com.example.demo.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class User {
    private Integer id;

    @NotBlank(message="用户名不能为空")
    @Pattern(regexp="^[a-zA-Z]\\\\w{5,17}$",message="用户名须以英文字母起始，且不能包含中文或特殊字符")
    private String userName;

    @NotBlank(message="密码不能为空")
    @Pattern(regexp="^[a-zA-Z0-9]{6,16}$",message="密码须设为英文字母或数值，6到16位")
    private String password;

    @NotBlank(message="手机号不能为空")
    @Pattern(regexp="^1[0-9]{10}$",message="手机号格式不正确")
    private String mobile;

    @NotBlank(message="邮箱不能为空")
    @Pattern(regexp="^([a-z0-9A-Z]+[-|\\\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\\\.)+[a-zA-Z]{2,}$",message="邮箱格式不正确")
    private String email;
}