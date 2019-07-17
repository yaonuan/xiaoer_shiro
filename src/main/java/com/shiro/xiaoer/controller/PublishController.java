package com.shiro.xiaoer.controller;

import com.shiro.xiaoer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : yaonuan
 * @Email : 806039077@qq.com
 * @Date : 2019/7/17
 */
@RestController
@RequestMapping("pub")
public class PublishController {

    @Autowired
    private UserService userService;


    @RequestMapping("find_user_info")
    public Object findUserInfo(@RequestParam("username")String username){
        return userService.findAllUserInfoByUsername(username);
    }

}
