package com.agony.service;

import com.agony.entities.Pay;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author agony
 * @description 针对表【t_pay(支付交易表)】的数据库操作Service
 * @createDate 2024-03-14 21:43:00
 */
public interface PayService extends IService<Pay> {
    int add(Pay pay);

    int delete(Integer id);

    int update(Pay pay);

    Pay getById(Integer id);

    List<Pay> getAll();
}
