package com.shiro.xiaoer.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro配置文件
 *
 * @Author : yaonuan
 * @Email : 806039077@qq.com
 * @Date : 2019/7/17
 */
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        System.out.println("执行ShiroFilterFactoryBean.shiroFilter");

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 必须设置securityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 需要登录的接口，如果访问某个接口，需要登录却没有登录，则使用调用此接口（如果前后端不是分离,则跳转页面）
        shiroFilterFactoryBean.setLoginUrl("/pub/need_login");
        // 登录成功，跳转url，如果前后端分离,则没这个调用
        shiroFilterFactoryBean.setSuccessUrl("/");
        // 没有权限，未授权调用这个方法 先验证登录->再验证是否有权限
        shiroFilterFactoryBean.setUnauthorizedUrl("/pub/not_permit");

        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 退出过滤器
        filterChainDefinitionMap.put("/logout", "logout");

        // 匿名可以访问，即游客模式
        filterChainDefinitionMap.put("/pub/**", "anon");
        // 登录才可以访问
        filterChainDefinitionMap.put("/authc/**", "authc");
        // 某个权限才可以访问的,管理员才可以访问
        filterChainDefinitionMap.put("/admin/**", "roles[admin]");
        // 编辑权限才可以访问
        filterChainDefinitionMap.put("/video/update", "perms[video_update]");
        // autc ：url定义必须通过认证才可以通过
        filterChainDefinitionMap.put("**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        // 如果不是前后端分离,则不必设置下面的setSessionManager
        securityManager.setSessionManager(sessionManager());
        // 设置realm推荐放到最后,某一些情况会不生效
        securityManager.setRealm(customRealm());
        return securityManager;
    }

    // 自定义realm
    @Bean
    public CustomRealm customRealm() {
        CustomRealm customRealm = new CustomRealm();

        customRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return customRealm;
    }

    // 自定义SessionManager
    @Bean
    public SessionManager sessionManager() {
        CustomSessionManager customSessionManager = new CustomSessionManager();
        // 设置会话超时候时间,默认是30分钟 会话超时时间：方法里面单位是毫秒
        customSessionManager.setGlobalSessionTimeout(20000);
        return customSessionManager;
    }

    // 密码加解密规则
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        // 设置散列算法,这里使用md5
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        // 散列次数
        hashedCredentialsMatcher.setHashIterations(2);

        return hashedCredentialsMatcher;
    }


}
