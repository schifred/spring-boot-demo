package com.example.demo.service;

import com.example.demo.dao.entity.Country;
import com.example.demo.dao.mapper.CountryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
public class CountryService {
    @Autowired
    private CountryMapper countryMapper;

    public Country select(int id){
        Example example = new Example(Country.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", id);
        return countryMapper.selectOneByExample(example);
    }
}
