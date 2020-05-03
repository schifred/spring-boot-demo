package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/alfred")
public class AlfredController {
    private static String test;

    @Value("${alfred.test}")
    public void setTest(String test) {
        AlfredController.test = test;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String getTest(){
        return this.test;
    }
}
