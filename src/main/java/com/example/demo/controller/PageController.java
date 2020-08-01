package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 页面 controller
 */
@Controller
public class PageController extends BaseController {
    @GetMapping("/")
    public String index(Model model){
        String env = System.getProperty("spring.profiles.active");
        model.addAttribute("env",env);
        return "index";
    }
}
