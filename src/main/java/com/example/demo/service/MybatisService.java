package com.example.demo.service;

import com.example.demo.dao.mapper.MybatisUserAnnotationMapper;
import com.example.demo.dao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MybatisService {
    @Autowired
    private MybatisUserAnnotationMapper mapper;

    public User getUser(Integer id){
        return mapper.getUser(id);
    }

    public void createUser(Map<String, Object> reqMap){
        mapper.createUser(reqMap);
    }

    public void updateUser(Integer id, String nickName){
        mapper.updateUser(id, nickName);
    }

    public void delete(Integer id){
        mapper.delete(id);
    }
}
