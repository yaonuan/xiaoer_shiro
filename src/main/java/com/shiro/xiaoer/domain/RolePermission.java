package com.shiro.xiaoer.domain;

import lombok.Data;

/**
 * 角色权限
 *
 * @Author : yaonuan
 * @Email : 806039077@qq.com
 * @Date : 2019/7/16
 */
@Data
public class RolePermission {

    private Integer id;

    private Integer roleId;

    private Integer permissionId;
}
