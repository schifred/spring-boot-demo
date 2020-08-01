package com.example.demo.service;

import com.example.demo.dto.UserDTO;

public interface UserService {
    public UserDTO getUser(Long id);

    public int createUser(UserDTO userDTO);

    public int updateUser(UserDTO userDTO);

    public int delete(Long id);
}
