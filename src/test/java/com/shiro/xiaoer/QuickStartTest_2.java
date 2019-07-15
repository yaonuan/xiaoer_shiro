package com.shiro.xiaoer;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author : yaonuan
 * @Email : 806039077@qq.com
 * @Date : 2019/7/13
 */
public class QuickStartTest_2 {

    private SimpleAccountRealm accountRealm = new SimpleAccountRealm();

    private DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();

    @Before
    public void init() {
        // 初始化数据源
        accountRealm.addAccount("xiaoer", "123", "root", "admin");
        accountRealm.addAccount("xiaomo", "456", "user");

        // 构建环境
        defaultSecurityManager.setRealm(accountRealm);

    }

    @Test
    public void testAuthentication() {
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        // 当前操作主体，application user
        Subject subject = SecurityUtils.getSubject();

        // 当前用户输入信息
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("xiaomo", "456");

        subject.login(usernamePasswordToken);

        System.out.println("认证结果:" + subject.isAuthenticated());

        System.out.println("是否有对应的root角色:" + subject.hasRole("root"));

        System.out.println("getPrincipal 认证结果:" + subject.getPrincipal());

        subject.logout();

        subject.checkRole("root");

        System.out.println("logout之后认证结果:" + subject.isAuthenticated());

    }
}
