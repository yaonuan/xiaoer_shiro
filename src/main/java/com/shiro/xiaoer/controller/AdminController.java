package com.shiro.xiaoer.controller;

import com.shiro.xiaoer.domain.JsonData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : yaonuan
 * @Email : 806039077@qq.com
 * @Date : 2019/7/18
 */
@RestController
@RequestMapping("/admin")
public class AdminController {


    @RequestMapping("/video/order")
    public JsonData findMyPlayRecord() {
        Map<String, Object> recordMap = new HashMap<>();

        recordMap.put("springboot课程1", "300元");
        recordMap.put("springboot课程2", "200元");
        recordMap.put("springboot课程3", "100元");
        recordMap.put("springboot课程4", "500元");

        return JsonData.buildSuccess(recordMap);
    }

}
