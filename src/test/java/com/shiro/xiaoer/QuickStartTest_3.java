package com.shiro.xiaoer;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/**
 * @Author : yaonuan
 * @Email : 806039077@qq.com
 * @Date : 2019/7/13
 */
public class QuickStartTest_3 {


    @Test
    public void testAuthentication() {
        // 创建SecurityManager工厂，通过配置文件ini创建
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");

        SecurityManager securityManager = factory.getInstance();
        // 将SecurityManager 设置到当前环境中
        SecurityUtils.setSecurityManager(securityManager);

        Subject subject =  SecurityUtils.getSubject();

        // 用户输入的账号和密码
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("xiaoxuan", "456");

        subject.login(usernamePasswordToken);

        System.out.println("认证结果:" + subject.isAuthenticated());

        System.out.println("是否有对应的root角色:" + subject.hasRole("user"));

        System.out.println("getPrincipal 认证结果:" + subject.getPrincipal());

        subject.checkPermission("video:find");

        System.out.println(subject.isPermitted("video:buy"));


    }
}
