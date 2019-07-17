package com.shiro.xiaoer.domain;

import lombok.Data;

/**
 * 用户角色
 *
 * @Author : yaonuan
 * @Email : 806039077@qq.com
 * @Date : 2019/7/16
 */
@Data
public class UserRole {

    private Integer id;

    private Integer userId;

    private Integer roleId;

    private String remarks;

}
