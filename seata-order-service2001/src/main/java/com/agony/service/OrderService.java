package com.agony.service;

import com.agony.entities.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author agony
 * @description 针对表【t_order】的数据库操作Service
 * @createDate 2024-03-28 21:13:29
 */
public interface OrderService extends IService<Order> {

    void create(Order order);
}
