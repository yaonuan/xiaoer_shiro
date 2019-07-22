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
@RequestMapping("/authc")
public class OrderController {


    @RequestMapping("/video/play_record")
    public JsonData findMyPlayRecord() {
        Map<String, Object> recordMap = new HashMap<>();

        recordMap.put("springboot课程1", "第一季");
        recordMap.put("springboot课程2", "第二季");
        recordMap.put("springboot课程3", "第三季");
        recordMap.put("springboot课程4", "第四季");

        return JsonData.buildSuccess(recordMap);
    }

}
