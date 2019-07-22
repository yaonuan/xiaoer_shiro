package com.shiro.xiaoer.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 权限
 *
 * @Author : yaonuan
 * @Email : 806039077@qq.com
 * @Date : 2019/7/16
 */
@Data
public class Permission implements Serializable {

    private Integer id;

    private String name;

    private String url;
}
