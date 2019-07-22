package com.shiro.xiaoer.config;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 * 自定义filter
 *
 * @Author : yaonuan
 * @Email : 806039077@qq.com
 * @Date : 2019/7/19
 */
public class CustomRolesAuthorizationFilter extends AuthorizationFilter {

    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {
        Subject subject = this.getSubject(request, response);
        // 获取当前访问路径所需要的角色限制集合
        String[] rolesArray = (String[]) ((String[]) mappedValue);
        if (rolesArray != null && rolesArray.length != 0) {
            Set<String> roles = CollectionUtils.asSet(rolesArray);
            // 当前subject是roles中的任意一个,则没有权限设置
            for (String role : roles) {
                if (subject.hasRole(role)) {
                    return true;
                }
            }
//            return subject.hasAllRoles(roles);
            return false;
        } else {
            // 没有访问限制就直接返回
            return true;
        }
    }

}
