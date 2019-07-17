package com.shiro.xiaoer.controller;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制层
 *
 * @Author : yaonuan
 * @Email : 806039077@qq.com
 * @Date : 2019/7/16
 */
@RestController
@RequestMapping("/api/admin/user")
public class UserController {

    @RequiresRoles(value = {"admin", "editor"}, logical = Logical.AND)
    @RequestMapping("/list_user")
    public Object listUser() {
        return null;
    }
}
