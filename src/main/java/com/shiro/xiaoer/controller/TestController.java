package com.shiro.xiaoer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : yaonuan
 * @Email : 806039077@qq.com
 * @Date : 2019/7/9
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "test yes";
    }

}
