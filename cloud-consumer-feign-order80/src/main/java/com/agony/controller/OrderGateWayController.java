package com.agony.controller;

import com.agony.apis.PayFeignApi;
import com.agony.resp.ResultData;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Agony
 * @create 2024/3/20 14:17
 */
@RestController
@Tag(name = "订单网关")
public class OrderGateWayController {
    @Resource
    private PayFeignApi payFeignApi;

    @GetMapping(value = "/feign/pay/gateway/get/{id}")
    public ResultData getGateWayId(@PathVariable("id") Integer id) {
        return payFeignApi.getGateWayById(id);
    }

    @GetMapping(value = "/feign/pay/gateway/info")
    public ResultData<String> getGatewayInfo() {
        return payFeignApi.getGatewayInfo();
    }
}
