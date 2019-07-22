package com.shiro.xiaoer.controller;

import com.shiro.xiaoer.domain.JsonData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : yaonuan
 * @Email : 806039077@qq.com
 * @Date : 2019/7/18
 */
@RestController
@RequestMapping("video")
public class VideoController {

    @RequestMapping("update")
    public JsonData updateVideo(){
        return JsonData.buildSuccess("video 更新成功");
    }

}
