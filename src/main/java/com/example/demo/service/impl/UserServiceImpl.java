package com.example.demo.service.impl;

import com.example.demo.dal.entity.User;
import com.example.demo.dal.mapper.UserMapper;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    public UserDTO getUser(Long id){
        UserDTO userDTO = new UserDTO();
        User user = userMapper.selectByPrimaryKey(id);
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }

    public int createUser(UserDTO userDTO){
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        return userMapper.insert(user);
    }

    public int updateUser(UserDTO userDTO){
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        return userMapper.updateByPrimaryKeySelective(user);
    }

    public int delete(Long id){
        return userMapper.deleteByPrimaryKey(id);
    }
}
