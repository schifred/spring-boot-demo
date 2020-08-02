package com.example.demo.dal.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {
    private Long id;

    private String userName;

    private String password;

    private String mobile;

    private String email;

    private Date gmtCreate;

    private String createNick;

    private Date gmtModified;

    private String modifiedNick;
}