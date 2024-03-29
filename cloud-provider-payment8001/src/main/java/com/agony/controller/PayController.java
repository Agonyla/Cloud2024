package com.agony.controller;

import com.agony.entities.Pay;
import com.agony.entities.PayDTO;
import com.agony.resp.ResultData;
import com.agony.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Slf4j
@Tag(name = "支付微服务模块", description = "支付CRUD")
public class PayController {
    @Resource
    private PayService payService;

    @PostMapping(value = "/pay/add")
    @Operation(summary = "新增", description = "新增支付流水")
    public ResultData<String> addPay(@RequestBody Pay pay) {
        int i = payService.add(pay);
        return ResultData.success("成功插入记录，返回值：" + i);
    }

    @PostMapping(value = "/pay/delete/{id}")
    @Operation(summary = "删除", description = "删除支付流水")
    public ResultData<Integer> deletePay(@PathVariable("id") Integer id) {
        int i = payService.delete(id);
        return ResultData.success(i);
    }

    @PutMapping(value = "/pay/update")
    @Operation(summary = "更新", description = "更新支付流水")
    public ResultData<String> updatePay(@RequestBody PayDTO payDTO) {
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);
        int i = payService.update(pay);
        return ResultData.success("成功修改记录，返回值：" + i);
    }

    @GetMapping(value = "/pay/get/{id}")
    @Operation(summary = "查询", description = "查询支付流水")
    public ResultData<Pay> getById(@PathVariable("id") Integer id) {
        if (id == null || id <= 0) {
            throw new RuntimeException("订单id需要 >= 0");
        }

        // try {
        //     TimeUnit.SECONDS.sleep(62);
        // } catch (InterruptedException e) {
        //     throw new RuntimeException(e);
        // }

        Pay pay = payService.getById(id);
        if (pay == null) {
            throw new RuntimeException("该订单不存在");
        }
        return ResultData.success(pay);
    }

    @GetMapping(value = "/pay/getAll")
    @Operation(summary = "查询所有", description = "查询所有支付流水")
    public ResultData<List<Pay>> getAll() {
        return ResultData.success(payService.getAll());
    }

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/pay/get/info")
    private String getInfoByConsul(@Value("${agony.info}") String info) {
        return "info: " + info + "\t" + "port: " + port;
    }


}
