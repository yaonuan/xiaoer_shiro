package com.shiro.xiaoer;

import com.shiro.xiaoer.domain.Role;
import com.shiro.xiaoer.domain.User;
import com.shiro.xiaoer.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author : yaonuan
 * @Email : 806039077@qq.com
 * @Date : 2019/7/19
 */
@SpringBootTest(classes = XiaoerApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class LambdaTest {

    @Autowired
    private UserService userService;

    @Test
    public void test(){
        String username = "jack";
        User user = userService.findAllUserInfoByUsername(username);

        List<String> a = new ArrayList<>();
        List<String> b = new ArrayList<>();
        List<Role> roleList = user.getRoleList();

        roleList.stream().forEach(role -> {
            System.out.println("role");
            a.add(role.getName());
            role.getPermissionList().forEach(permission -> {
                b.add(permission.getName());
            });
        });

        System.out.println("======》");
        System.out.println(a);
        System.out.println(b);
    }
}
