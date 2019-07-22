package com.shiro.xiaoer.controller;

import com.shiro.xiaoer.domain.JsonData;
import com.shiro.xiaoer.domain.UserQuery;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author : yaonuan
 * @Email : 806039077@qq.com
 * @Date : 2019/7/17
 */
@RestController
@RequestMapping("pub")
public class PublishController {


    @RequestMapping("need_login")
    public JsonData needLogin(){
        return JsonData.buildSuccess("温馨提示:请使用对应的账号登录!","-2");
    }

    @RequestMapping("not_permit")
    public JsonData notPermit(){
        return JsonData.buildSuccess("温馨提示:拒绝访问,没有权限","-3");
    }

    @RequestMapping("index")
    public JsonData index(){
        List<String> videoList = new ArrayList<>();
        videoList.add("现在的你应该去看B站，放松下");

        return JsonData.buildSuccess(videoList);
    }

    @PostMapping("login")
    public JsonData login(@RequestBody UserQuery userQuery, HttpServletRequest request, HttpServletResponse response){
        Subject subject = SecurityUtils.getSubject();
        Map<String,Object> info = new HashMap<>();

        try {
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userQuery.getName(),userQuery.getPassword());
            subject.login(usernamePasswordToken);

            info.put("msg","登录成功");
            info.put("session_id",subject.getSession().getId());
            return JsonData.buildSuccess(info);
        } catch (AuthenticationException e) {
//            e.printStackTrace();
            return JsonData.buildError("账号或者密码错误");
        }


    }
}
