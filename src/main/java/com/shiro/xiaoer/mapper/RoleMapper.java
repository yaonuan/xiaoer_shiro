package com.shiro.xiaoer.mapper;

import com.shiro.xiaoer.domain.Role;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @Author : yaonuan
 * @Email : 806039077@qq.com
 * @Date : 2019/7/17
 */
public interface RoleMapper {

    @Select("SELECT ur.role_id AS id,r.`name` AS name,r.description AS description FROM user_role ur LEFT JOIN role r ON ur.role_id = r.id WHERE ur.user_id = #{userId}")
    @Results(
            value = {
                    @Result(id = true, column = "id", property = "id"),
                    @Result(column = "name", property = "name"),
                    @Result(column = "description", property = "description"),
                    @Result(column = "id", property = "permissionList",
                            many = @Many(select = "com.shiro.xiaoer.mapper.PermissionMapper.findPermissionListByRoleId",fetchType = FetchType.DEFAULT)
                    )
            }
    )
    List<Role> findRoleListByUserId(@Param("userId") Integer userId);
}
