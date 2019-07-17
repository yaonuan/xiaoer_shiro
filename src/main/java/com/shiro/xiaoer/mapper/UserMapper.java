package com.shiro.xiaoer.mapper;

import com.shiro.xiaoer.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author : yaonuan
 * @Email : 806039077@qq.com
 * @Date : 2019/7/16
 */
public interface UserMapper {

    @Select("select * from user where username = #{username}")
    User findByUsername(@Param("username")String username);

    @Select("select * from user where id = #{userId}")
    User findById(@Param("userId")Integer id);

    @Select("select * from user where username = #{username} and password = #{password}")
    User findByUsernameAndPwd(@Param("username")String username,@Param("password")String password);
}
