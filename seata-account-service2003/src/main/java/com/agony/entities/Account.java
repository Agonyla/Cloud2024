package com.agony.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @TableName t_account
 */
@TableName(value = "t_account")
@Data
public class Account implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 总额度
     */
    private Integer total;

    /**
     * 已用账户余额
     */
    private Integer used;

    /**
     * 剩余可用额度
     */
    private Integer residue;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}