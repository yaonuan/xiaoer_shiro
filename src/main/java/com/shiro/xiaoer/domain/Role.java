package com.shiro.xiaoer.domain;

import lombok.Data;

import java.util.List;

/**
 * 角色
 *
 * @Author : yaonuan
 * @Email : 806039077@qq.com
 * @Date : 2019/7/16
 */
@Data
public class Role {

    private Integer id;

    private String name;

    private String description;

    /**
     * 权限集合
     */
    private List<Permission> permissionList;
}
