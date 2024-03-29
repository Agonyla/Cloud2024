package com.agony.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 支付交易表
 *
 * @TableName t_pay
 */
@TableName(value = "t_pay")
@Data
public class Pay implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 支付流水号
     */
    @Schema(title = "支付流水号")
    private String payNo;

    /**
     * 订单流水号
     */
    @Schema(title = "订单流水号")
    private String orderNo;

    /**
     * 用户账号ID
     */
    @Schema(title = "用户账号ID")
    private Integer userId;

    /**
     * 交易金额
     */
    @Schema(title = "交易金额")
    private BigDecimal amount;

    /**
     * 删除标志，默认0不删除，1删除
     */
    private Integer deleted;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}