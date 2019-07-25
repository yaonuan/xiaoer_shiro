package com.shiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.shiro.**.mapper")
public class XiaoerApplication {

    public static void main(String[] args) {
        System.out.println();
        SpringApplication.run(XiaoerApplication.class, args);
    }

}
