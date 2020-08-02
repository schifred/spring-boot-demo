package com.example.demo.service;

import com.example.demo.BaseTest;
import com.example.demo.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class UserServiceTest extends BaseTest {
    @Autowired
    private UserService userService;

    @Test
    public void getUser(){
        UserDTO userDTO = userService.getUser(1001L);
        Assert.assertNotNull("has user", userDTO.getUserName());
    }
}
