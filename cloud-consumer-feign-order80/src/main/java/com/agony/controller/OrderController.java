package com.agony.controller;

import cn.hutool.core.date.DateUtil;
import com.agony.apis.PayFeignApi;
import com.agony.entities.PayDTO;
import com.agony.resp.ResultData;
import com.agony.resp.ReturnCodeEnum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author Agony
 * @create 2024/3/15 13:58
 */
@RestController
@Slf4j
@Tag(name = "客户微服务模块", description = "客户CRUD")
public class OrderController {


    @Resource
    private PayFeignApi payFeignApi;

    /**
     * 新增订单
     *
     * @param payDTO
     * @return
     */
    @PostMapping("/feign/pay/add")
    @Operation(summary = "新增订单")
    public ResultData addOrder(@RequestBody PayDTO payDTO) {
        return payFeignApi.addPay(payDTO);
    }

    /**
     * 删除订单
     *
     * @param id
     * @return
     */
    @PostMapping("/feign/pay/delete/{id}")
    @Operation(summary = "删除订单")
    public ResultData deleteOrder(@PathVariable("id") Integer id) {
        return payFeignApi.deletePay(id);
    }

    /**
     * 修改订单
     *
     * @param payDTO
     * @return
     */
    @PostMapping("/feign/pay/update")
    @Operation(summary = "修改订单")
    public ResultData updateOrder(@RequestBody PayDTO payDTO) {
        return payFeignApi.updatePay(payDTO);
    }

    /**
     * 查询订单
     *
     * @param id
     * @return
     */
    @GetMapping("/feign/pay/get/{id}")
    @Operation(summary = "查询订单")
    public ResultData getOrder(@PathVariable("id") Integer id) {
        // return payFeignApi.getById(id);
        System.out.println("############### 支付微服务远程调用，按照id查询订单支付流水信息 ###############");
        ResultData resultData = null;
        try {
            System.out.println("调用开始-----:" + DateUtil.now());
            resultData = payFeignApi.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("调用结束-----:" + DateUtil.now());
            ResultData.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
        }
        return resultData;
    }

    /**
     * 查询所有订单
     *
     * @return
     */
    @GetMapping("/feign/pay/getAll")
    @Operation(summary = "查询所有订单")
    public ResultData getAllOrder() {
        return payFeignApi.getAll();
    }

    /**
     * @return
     */
    @GetMapping("/feign/pay/get/info")
    public String getPayInfo() {
        return payFeignApi.getInfo();
    }

}
