package com.shiro.xiaomo.controller;

import com.shiro.xiaomo.service.RedPacketInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : yaonuan
 * @Email : 806039077@qq.com
 * @Date : 2019/9/5
 */
@RestController
@RequestMapping("/red_packet")
public class RedPacketController {


    @Autowired
    private RedPacketInfoService packetInfoService;

    @RequestMapping("/add_packet")
    public String saveRedPacket(Integer uid, Integer totalNum, Integer totalAmount) {

        packetInfoService.saveRedPacket(uid,totalNum,totalAmount);
        return "success";
    }

}
