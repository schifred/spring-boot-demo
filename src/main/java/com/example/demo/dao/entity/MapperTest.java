package com.example.demo.dao.entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "country")
public class MapperTest {
    @Id
    private Integer id;
    private String  countryname;
    private String  countrycode;

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getCountryname(){
        return countryname;
    }

    public void setCountryname(String nickName){
        this.countryname = nickName;
    }

    public String getCountrycode(){
        return countrycode;
    }

    public void setCountrycode(String nickName){
        this.countrycode = nickName;
    }
}