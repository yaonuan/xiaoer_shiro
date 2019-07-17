package com.shiro.xiaoer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.shiro.xiaoer.mapper")
public class XiaoerApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiaoerApplication.class, args);
    }

}
