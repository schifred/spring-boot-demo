package com.example.demo.controller;

import com.example.demo.BaseTest;
import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

public class UserControllerTest extends BaseTest {
    @Resource
    UserController userController;

    @Test
    public void getUser() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/user/getUser?id=1001"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
            .andExpect(MockMvcResultMatchers.content().string("{\"code\":200,\"msg\":\"success\",\"success\":true,\"data\":{\"id\":null,\"userName\":\"李四\",\"password\":\"123456\",\"mobile\":\"18888888888\",\"email\":\"lisi@test.com\"}}"))
            .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void createUser() {
    }

    @Test
    public void updateUser() {
    }

    @Test
    public void deleteUser() {
    }
}