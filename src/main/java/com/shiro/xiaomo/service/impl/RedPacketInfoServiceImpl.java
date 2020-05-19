package com.shiro.xiaomo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shiro.xiaomo.entity.RedPacketInfo;
import com.shiro.xiaomo.entity.RedPacketRecord;
import com.shiro.xiaomo.mapper.RedPacketInfoMapper;
import com.shiro.xiaomo.mapper.RedPacketRecordMapper;
import com.shiro.xiaomo.service.RedPacketInfoService;
import com.shiro.xiaomo.service.RedisService;
import com.shiro.xiaomo.utils.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author : yaonuan
 * @Email : 806039077@qq.com
 * @Date : 2019/9/5
 */
@Service
public class RedPacketInfoServiceImpl extends ServiceImpl<RedPacketInfoMapper, RedPacketInfo> implements RedPacketInfoService {

    @Autowired
    private RedPacketInfoMapper packetInfoMapper;

    @Autowired
    private RedisService redisService;

    @Autowired
    private RedPacketRecordMapper redPacketRecordMapper;

    @Override
    public String saveRedPacket(Integer uid, Integer totalNum, Integer totalAmount) {
        // 新增红包
        RedPacketInfo redPacketInfo = new RedPacketInfo();
        redPacketInfo.setUid(uid);
        redPacketInfo.setTotalAmount(totalAmount);
        redPacketInfo.setTotalPacket(totalNum);
        redPacketInfo.setCreateTime(new Date());
        // 使用雪花算法构建唯一性的红包ID
        Long redPacketId =  new SnowFlake(1, 1).nextId();
        redPacketInfo.setRedPacketId(redPacketId);
        packetInfoMapper.insert(redPacketInfo);
        // redis添加缓存
        redisService.set(redPacketId + "_totalNum", totalNum);
        redisService.set(redPacketId + "_totalAmount", totalAmount);
        return "success";
    }


    @Override
    public String getRedPacket(Integer uid, long redPacketId) {
        // 新增红包记录
        RedPacketRecord record = new RedPacketRecord();
        record.setUid(uid);
        record.setRedPacketId(redPacketId);
        // 红包抢的金额计算
        record.setAmount(111);
        record.setCreateTime(new Date());
        redPacketRecordMapper.insert(record);

        redisService.decr(redPacketId + "_totalNum", 1);
        return null;
    }
}
