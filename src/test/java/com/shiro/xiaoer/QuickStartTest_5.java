package com.shiro.xiaoer;

import org.apache.shiro.mgt.DefaultSecurityManager;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author : yaonuan
 * @Email : 806039077@qq.com
 * @Date : 2019/7/13
 */
public class QuickStartTest_5 {

    private CustomRealm customRealm = new CustomRealm();

    private DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();


    @Before
    public void init(){
        defaultSecurityManager.setRealm(customRealm);
    }

    @Test
    public void testAuthentication() {


    }
}
