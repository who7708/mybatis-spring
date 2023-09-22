package org.mybatis.my.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.my.model.User;

// @Mapper 注解主要是在
// <mybatis-spring:scan annotation="org.apache.ibatis.annotations.Mapper"
// 或
// ClassPathMapperScanner#setAnnotationClass(Mapper.class)
// 在这两个地方使用的.也可以不添加此注解
// @Mapper
// @Component
public interface UserMapper {

    @Select("select * from t_user where name = #{name}")
    User find(String name);

    @Select("select * from t_user where name = #{name} and pwd = #{pwd}")
    User login(@Param("name") String name, @Param("pwd") String pwd);
}