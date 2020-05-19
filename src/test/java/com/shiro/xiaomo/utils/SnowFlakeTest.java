package com.shiro.xiaomo.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author : yaonuan
 * @Email : 806039077@qq.com
 * @Date : 2019/9/9
 */
public class SnowFlakeTest {

    @Test
    public void nextId() {
        SnowFlake snowFlake = new SnowFlake(1, 1);
        Long l = snowFlake.nextId();
        System.out.println(l);
    }
}