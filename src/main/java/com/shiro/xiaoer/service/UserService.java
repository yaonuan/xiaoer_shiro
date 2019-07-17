package com.shiro.xiaoer.service;

import com.shiro.xiaoer.domain.User;

/**
 * @Author : yaonuan
 * @Email : 806039077@qq.com
 * @Date : 2019/7/17
 */
public interface UserService {

    /**
     * 获取全部用户信息，包括角色、权限
     *
     * @param username
     * @return
     */
    User findAllUserInfoByUsername(String username);

    /**
     * 获取用户基本信息
     *
     * @param userId
     * @return
     */
    User findSimpleUserInfoById(Integer userId);

    /**
     * 根据用户名查找用户信息
     *
     * @param username
     * @return
     */
    User findSimpleUserInfoByUsername(String username);


}
