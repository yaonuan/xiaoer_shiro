package com.shiro.xiaoer;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 自定义realm
 *
 * @Author : yaonuan
 * @Email : 806039077@qq.com
 * @Date : 2019/7/15
 */
public class CustomRealm extends AuthorizingRealm {

    private final Map<String, String> userInfoMap = new HashMap<>();

    {
        userInfoMap.put("jack", "123");
        userInfoMap.put("xiaomo", "456");
    }

    // role -> permission
    private final Map<String, Set<String>> permissionMap = new HashMap<>();

    {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        set1.add("video:find");
        set1.add("video:buy");

        set2.add("video:add");
        set2.add("video:delete");

        permissionMap.put("jack", set1);
        permissionMap.put("xiaomo", set2);
    }

    // user -> role
    private final Map<String, Set<String>> roleMap = new HashMap<>();

    {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        set1.add("role1");
        set1.add("role2");

        set2.add("root");

        roleMap.put("jack", set1);
        roleMap.put("xiaomo", set2);
    }

    // 进行权限校验的时候会调用
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("权限校验 doGetAuthorizationInfo");

        String name = (String) principalCollection.getPrimaryPrincipal();

        Set<String> permissions = getPermissionsByNameFromDB(name);

        Set<String> roles = getRolesByNameFromDB(name);

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        simpleAuthorizationInfo.setRoles(roles);

        simpleAuthorizationInfo.setStringPermissions(permissions);

        return simpleAuthorizationInfo;
    }


    // 当用户登陆的时候会调用
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        System.out.println("认证 doGetAuthenticationInfo");

        //从token获取身份信息，token代表用户输入的信息
        String name = (String) authenticationToken.getPrincipal();

        //模拟从数据库中取密码
        String pwd = getPwdByUserNameFromDb(name);

        if (pwd == null || "".equals(pwd)) {
            return null;
        }

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name, pwd, this.getName());

        return simpleAuthenticationInfo;
    }

    /**
     * 模拟从数据库获取用户角色集合
     * @param name
     * @return
     */
    private Set<String> getRolesByNameFromDB(String name) {
        return roleMap.get(name);
    }

    /**
     * 模拟从数据库获取权限集合
     * @param name
     * @return
     */
    private Set<String> getPermissionsByNameFromDB(String name) {
        return permissionMap.get(name);
    }
    private String getPwdByUserNameFromDb(String name) {
        return userInfoMap.get(name);
    }
}
