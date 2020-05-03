package com.example.demo.dao.entity;

import javax.persistence.*;

@Table(name = "mapper_test")
public class MapperTest {
    @GeneratedValue(generator = "JDBC")
    private String name;

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}