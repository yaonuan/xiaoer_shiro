package com.shiro.xiaomo.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("red_packet_info")
public class RedPacketInfo extends Model<RedPacketInfo> implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private Integer id;
    /**
     * 红包id，采用timestamp+5位随机数
     */
    private Long redPacketId;
    /**
     * 红包总金额，单位分
     */
    private Integer totalAmount;
    /**
     * 红包总个数
     */
    private Integer totalPacket;
    /**
     * 剩余红包金额，单位分
     */
    private Integer remainingAmount;
    /**
     * 剩余红包个数
     */
    private Integer remainingPacket;
    /**
     * 新建红包用户的用户标识
     */
    private Integer uid;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

}
