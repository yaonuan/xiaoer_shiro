package com.shiro.xiaoer.config;

import com.shiro.xiaoer.domain.Permission;
import com.shiro.xiaoer.domain.Role;
import com.shiro.xiaoer.domain.User;
import com.shiro.xiaoer.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : yaonuan
 * @Email : 806039077@qq.com
 * @Date : 2019/7/16
 */
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 进行权限校验的时候调用
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权 doGetAuthorizationInfo");
        User newUser = (User) principalCollection.getPrimaryPrincipal();

        User user = userService.findAllUserInfoByUsername(newUser.getUsername());

        List<String> stringRoleList = new ArrayList<>();
        List<String> stringPermissionList = new ArrayList<>();

        List<Role> roleList = user.getRoleList();
        for (Role role :roleList) {
            stringRoleList.add(role.getName());
            List<Permission> permissionList = role.getPermissionList();
            for (Permission permission :permissionList) {
                if (permission != null){
                stringPermissionList.add(permission.getName());
                }
            }

        }

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRoles(stringRoleList);
        simpleAuthorizationInfo.addStringPermissions(stringPermissionList);

        return simpleAuthorizationInfo;
    }

    /**
     * 用户登录认证(登录时会使用)
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("认证 doGetAuthenticationInfo");
        // token获取用户信息,token是用户输入的信息
        String username = (String) authenticationToken.getPrincipal();

        User user = userService.findAllUserInfoByUsername(username);

        String pwd = user.getPassword();
        if (pwd == null || "".equals(pwd)){
            return null;
        }

        return new SimpleAuthenticationInfo(user,user.getPassword(),this.getClass().getName());
    }
}
