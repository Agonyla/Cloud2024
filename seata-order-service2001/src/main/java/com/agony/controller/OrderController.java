package com.agony.controller;

import com.agony.entities.Order;
import com.agony.resp.ResultData;
import com.agony.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Agony
 * @create 2024/3/28 21:37
 */
@RestController
@Slf4j
@Tag(name = "Seata订单模块")
public class OrderController {

    @Resource
    private OrderService orderService;

    /**
     * 创建订单
     *
     * @param order
     * @return
     */
    @PostMapping("/seata/order/create")
    @Operation(summary = "创建订单")
    public ResultData<Order> create(@RequestBody Order order) {
        orderService.create(order);
        return ResultData.success(order);
    }
}
