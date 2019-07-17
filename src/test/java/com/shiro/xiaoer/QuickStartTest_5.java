package com.shiro.xiaoer;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

/**
 * @Author : yaonuan
 * @Email : 806039077@qq.com
 * @Date : 2019/7/13
 */
public class QuickStartTest_5 {

    private CustomRealm customRealm = new CustomRealm();

    private DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();


    @Before
    public void init(){
        // 构建环境
        defaultSecurityManager.setRealm(customRealm);
        SecurityUtils.setSecurityManager(defaultSecurityManager);
    }

    @Test
    public void testAuthentication() {
        // 去当前操作主体
        Subject subject = SecurityUtils.getSubject();

        // 用户输入的账号和密码
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("jack", "123");

        subject.login(usernamePasswordToken);

        // 获取主体标示属性
        System.out.println("认证结果:" + subject.isAuthenticated());

        System.out.println("getPrincipal 认证结果:" + subject.getPrincipal());

        subject.checkRole("role1");

        System.out.println("是否有对应的角色"+ subject.hasRole("role1"));
        System.out.println("是否有对应的权限"+ subject.isPermitted("video:find"));
    }
}
