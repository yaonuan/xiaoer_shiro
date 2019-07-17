package com.shiro.xiaoer.service.impl;

import com.shiro.xiaoer.domain.Role;
import com.shiro.xiaoer.domain.User;
import com.shiro.xiaoer.mapper.RoleMapper;
import com.shiro.xiaoer.mapper.UserMapper;
import com.shiro.xiaoer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author : yaonuan
 * @Email : 806039077@qq.com
 * @Date : 2019/7/17
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findAllUserInfoByUsername(String username) {

        User user = userMapper.findByUsername(username);
        // 用户角色集合
        List<Role> roleList = roleMapper.findRoleListByUserId(user.getId());

        user.setRoleList(roleList);
        return user;
    }

    @Override
    public User findSimpleUserInfoById(Integer userId) {
        return userMapper.findById(userId);
    }

    @Override
    public User findSimpleUserInfoByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}
