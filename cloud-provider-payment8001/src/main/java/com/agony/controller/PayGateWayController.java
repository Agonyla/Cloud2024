package com.agony.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.agony.entities.Pay;
import com.agony.resp.ResultData;
import com.agony.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;

/**
 * @author Agony
 * @create 2024/3/20 14:03
 */
@RestController
@Tag(name = "支付网关模块")
public class PayGateWayController {
    @Resource
    PayService payService;

    @GetMapping(value = "/pay/gateway/get/{id}")
    @Operation(summary = "查询id")
    public ResultData<Pay> getById(@PathVariable("id") Integer id) {
        Pay pay = payService.getById(id);
        if (pay == null) {
            throw new RuntimeException("该订单不存在");
        }
        return ResultData.success(pay);
    }

    @GetMapping(value = "/pay/gateway/info")
    @Operation(summary = "查询信息")
    public ResultData<String> getGatewayInfo() {
        return ResultData.success("gateway info test：" + IdUtil.simpleUUID());
    }

    @GetMapping(value = "/pay/gateway/filter")
    @Operation(summary = "过滤器")
    public ResultData<String> getGatewayFilter(HttpServletRequest request) {
        StringBuilder result = new StringBuilder();
        Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()) {
            String headName = headers.nextElement();
            String headValue = request.getHeader(headName);
            System.out.println("请求头名: " + headName + "\t\t\t" + "请求头值: " + headValue);
            if (headName.equalsIgnoreCase("X-Request-agony1")
                    || headName.equalsIgnoreCase("X-Request-agony2")) {
                result.append(headName).append("\t ").append(headValue).append(" ");
            }
        }

        System.out.println("=============================================");
        String customerId = request.getParameter("customerId");
        System.out.println("request Parameter customerId: " + customerId);

        String customerName = request.getParameter("customerName");
        System.out.println("request Parameter customerName: " + customerName);
        System.out.println("=============================================");


        return ResultData.success("getGatewayFilter 过滤器 test： " + result + " \t " + DateUtil.now());
    }
}
