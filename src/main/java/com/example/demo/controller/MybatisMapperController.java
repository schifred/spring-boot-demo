package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.dao.entity.Country;
import com.example.demo.consts.Result;
import com.example.demo.service.CountryService;
import com.example.demo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MybatisMapperController {
    @Autowired
    private CountryService countryService;

    @GetMapping("/getCountry/{id}")
    public Result get(@PathVariable("id") int id){
        System.out.print(id);
        Country country = countryService.select(id);
        System.out.print(JSON.toJSONString(country));
        return ResultUtil.success(country);
    }
}
