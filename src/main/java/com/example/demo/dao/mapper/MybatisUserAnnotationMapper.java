package com.example.demo.dao.mapper;

import com.example.demo.dao.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.Map;

@Mapper
public interface MybatisUserAnnotationMapper {
    // @Select("SELECT id,nickname FROM demo.user WHERE id = #{id}")
    User getUser(@Param("id") Integer id);

    // @Insert("INSERT INTO demo.user(nickname)")
    void createUser(Map<String, Object> reqMap);

    // @Update("UPDATE demo.user SET nickname = #{nickName} WHERE id = #{id}")
    void updateUser(@Param("id") Integer id, @Param("nickName") String nickName);

    // @Delete("DELETE FROM demo.user WHERE id = #{id}")
    void delete(@Param("id") Integer id);
}
