package com.shiro.xiaoer.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户
 *
 * @Author : yaonuan
 * @Email : 806039077@qq.com
 * @Date : 2019/7/16
 */
@Data
public class User implements Serializable {

    private Integer id;

    private String username;

    private String password;

    private Date createTime;

    private String salt;

    /**
     * 角色集合
     */
    private List<Role> roleList;

}
