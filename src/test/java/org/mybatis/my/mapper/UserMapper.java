package org.mybatis.my.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.my.model.User;

@Mapper
public interface UserMapper {

    @Select("select * from t_user where name = #{name}")
    User find(String name);

    @Select("select * from t_user where name = #{name} and pwd = #{pwd}")
    User login(@Param("name") String name, @Param("pwd") String pwd);
}