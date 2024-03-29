package com.agony.apis;

import com.agony.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Agony
 * @create 2024/3/27 16:17
 */
@FeignClient(value = "nacos-payment-provider", fallback = PayFeignSentinelApiFallback.class)
public interface PayFeignSentinelApi {


    @GetMapping("/pay/nacos/get/{orderNo}")
    ResultData getPayByOrderNo(@PathVariable("orderNo") String orderNo);
}
