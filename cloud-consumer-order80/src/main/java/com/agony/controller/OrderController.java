package com.agony.controller;

import com.agony.entities.PayDTO;
import com.agony.resp.ResultData;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author Agony
 * @create 2024/3/15 13:58
 */
@RestController
@Slf4j
// @Tag(name = "客户微服务模块", description = "客户CRUD")
public class OrderController {

    // public static final String PaymentStv_URL = "http://localhost:8001";
    public static final String PaymentStv_URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    /**
     * 新增订单
     *
     * @param payDTO
     * @return
     */
    @PostMapping("/consumer/pay/add")
    @Operation(summary = "新增订单")
    public ResultData addOrder(@RequestBody PayDTO payDTO) {
        return restTemplate.postForObject(PaymentStv_URL + "/pay/add", payDTO, ResultData.class);
    }

    /**
     * 删除订单
     *
     * @param id
     * @return
     */
    @PostMapping("/consumer/pay/delete/{id}")
    @Operation(summary = "删除订单")
    public ResultData deleteOrder(@PathVariable("id") Integer id) {
        return restTemplate.postForObject(PaymentStv_URL + "/pay/delete/" + id, id, ResultData.class);
    }

    /**
     * 修改订单
     *
     * @param payDTO
     * @return
     */
    @PostMapping("/consumer/pay/update")
    @Operation(summary = "修改订单")
    public ResultData updateOrder(@RequestBody PayDTO payDTO) {
        return restTemplate.postForObject(PaymentStv_URL + "/pay/update", payDTO, ResultData.class);
    }

    /**
     * 查询订单
     *
     * @param id
     * @return
     */
    @GetMapping("/consumer/pay/get/{id}")
    @Operation(summary = "查询订单")
    public ResultData getOrder(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(PaymentStv_URL + "/pay/get/" + id, ResultData.class, id);
    }

    /**
     * 查询所有订单
     *
     * @return
     */
    @GetMapping("/consumer/pay/getAll")
    @Operation(summary = "查询所有订单")
    public ResultData getAllOrder() {
        return restTemplate.getForObject(PaymentStv_URL + "/pay/getAll", ResultData.class);
    }

    /**
     * 获取信息
     *
     * @return
     */
    @GetMapping("/consumer/pay/get/info")
    public String getPayInfo() {
        return restTemplate.getForObject(PaymentStv_URL + "/pay/get/info", String.class);
    }

}
