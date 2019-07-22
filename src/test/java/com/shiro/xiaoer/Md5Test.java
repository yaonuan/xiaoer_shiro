package com.shiro.xiaoer;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;

/**
 * @Author : yaonuan
 * @Email : 806039077@qq.com
 * @Date : 2019/7/18
 */
public class Md5Test {

    @Test
    public void md5() {

        String hashName = "md5";

        String pwd = "123456789";

        Object result = new SimpleHash(hashName, pwd, null, 2);

        System.out.println(result);
    }

}
