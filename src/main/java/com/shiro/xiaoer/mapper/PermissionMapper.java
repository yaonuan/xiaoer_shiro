package com.shiro.xiaoer.mapper;

import com.shiro.xiaoer.domain.Permission;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author : yaonuan
 * @Email : 806039077@qq.com
 * @Date : 2019/7/17
 */
public interface PermissionMapper {

    @Select("SELECT p.id AS id,p.`name` AS name,p.url AS url FROM role_permission rp LEFT JOIN permission p ON rp.permission_id = p.id WHERE rp.role_id = 3")
    List<Permission> findPermissionListByRoleId(@Param("roleId")Integer roleId);
}
