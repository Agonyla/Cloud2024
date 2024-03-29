package com.agony.controller;

import cn.hutool.core.util.IdUtil;
import com.agony.entities.PayDTO;
import com.agony.resp.ResultData;
import com.agony.resp.ReturnCodeEnum;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author Agony
 * @create 2024/3/27 16:14
 */
@RestController
@Slf4j
@Tag(name = "Alibaba消费模块")
public class PayAlibabaController {


    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/pay/nacos/{id}")
    public String getPayInfo(@PathVariable("id") Integer id) {
        return "nacos registry, serverPort: " + serverPort + "\t id" + id;
    }

    @GetMapping("/pay/nacos/get/{orderNo}")
    @SentinelResource(value = "getPayByOrderNo", blockHandler = "handlerBlockHandler")
    public ResultData getPayByOrderNo(@PathVariable("orderNo") String orderNo) {
        //模拟从数据库查询出数据并赋值给DTO
        PayDTO payDTO = new PayDTO();

        payDTO.setId(1024);
        payDTO.setOrderNo(orderNo);
        payDTO.setAmount(BigDecimal.valueOf(9.9));
        payDTO.setPayNo("pay:" + IdUtil.fastUUID());
        payDTO.setUserId(1);

        return ResultData.success("查询返回值：" + payDTO);
    }

    public ResultData handlerBlockHandler(@PathVariable("orderNo") String orderNo, BlockException exception) {
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(), "getPayByOrderNo服务不可用，" +
                "触发sentinel流控配置规则" + "\t" + "o(╥﹏╥)o");
    }


    // // fallback服务降级方法纳入到Feign接口统一处理，全局一个
    // public ResultData myFallBack(@PathVariable("orderNo") String orderNo, Throwable throwable) {
    //     return ResultData.fail(ReturnCodeEnum.RC500.getCode(), "异常情况：" + throwable.getMessage());
    // }

}
