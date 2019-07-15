package com.shiro.xiaoer;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.catalina.realm.JDBCRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/**
 * @Author : yaonuan
 * @Email : 806039077@qq.com
 * @Date : 2019/7/13
 */
public class QuickStartTest_4 {


    @Test
    public void testAuthentication() {
        // 创建SecurityManager工厂，通过配置文件ini创建
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:jdbcrealm.ini");

        SecurityManager securityManager = factory.getInstance();
        // 将SecurityManager 设置到当前环境中
        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();

        // 用户输入的账号和密码
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("jack", "123");

        subject.login(usernamePasswordToken);

        System.out.println("认证结果:" + subject.isAuthenticated());

        System.out.println("是否有对应的root角色:" + subject.hasRole("admin"));

        System.out.println("getPrincipal 认证结果:" + subject.getPrincipal());

        subject.checkPermission("video:find");

        System.out.println(subject.isPermitted("video:buy"));
    }

    @Test
    public void testAuthentication2() {
        DefaultSecurityManager securityManager = new DefaultSecurityManager();

        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://106.14.176.127:3306/xiaoer_shiro?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false");
        ds.setUsername("root");
        ds.setPassword("12345678");


        JdbcRealm jdbcRealm = new JdbcRealm();
        jdbcRealm.setPermissionsLookupEnabled(true);
        jdbcRealm.setDataSource(ds);

        securityManager.setRealm(jdbcRealm);

        // 将SecurityManager 设置到当前环境中
        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();

        // 用户输入的账号和密码
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("jack", "1234");

        subject.login(usernamePasswordToken);

        System.out.println("认证结果:" + subject.isAuthenticated());

        System.out.println("是否有对应的root角色:" + subject.hasRole("admin"));

        System.out.println("getPrincipal 认证结果:" + subject.getPrincipal());

        subject.checkPermission("video:find");

        System.out.println(subject.isPermitted("video:buy"));
    }
}
