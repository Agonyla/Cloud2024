package com.agony.apis;

import com.agony.entities.PayDTO;
import com.agony.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Agony
 * @create 2024/3/17 21:54
 */
// @FeignClient(name = "cloud-payment-service")
@FeignClient(name = "cloud-gateway")
public interface PayFeignApi {

    /**
     * 新增支付流水
     *
     * @param payDTO
     * @return
     */
    @PostMapping(value = "/pay/add")
    ResultData<String> addPay(@RequestBody PayDTO payDTO);

    /**
     * 删除支付流水
     *
     * @param id
     * @return
     */
    @PostMapping(value = "/pay/delete/{id}")
    ResultData<Integer> deletePay(@PathVariable("id") Integer id);

    /**
     * 更新支付流水
     *
     * @param payDTO
     * @return
     */
    @PutMapping(value = "/pay/update")
    ResultData<String> updatePay(@RequestBody PayDTO payDTO);

    /**
     * 查询支付流水
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/pay/get/{id}")
    ResultData<PayDTO> getById(@PathVariable("id") Integer id);

    /**
     * 查询所有支付流水
     *
     * @return
     */
    @GetMapping(value = "/pay/getAll")
    ResultData<List<PayDTO>> getAll();

    /**
     * 查询信息
     *
     * @return
     */
    @GetMapping(value = "/pay/get/info")
    String getInfo();

    /**
     * Resilience4j CircuitBreaker 的例子
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/pay/circuit/{id}")
    String myCircuit(@PathVariable("id") Integer id);


    /**
     * Micrometer(Sleuth)进行链路监控的例子
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/pay/micrometer/{id}")
    String myMicrometer(@PathVariable("id") Integer id);


    /**
     * GateWay进行网关测试案例01
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/pay/gateway/get/{id}")
    ResultData getGateWayById(@PathVariable("id") Integer id);

    /**
     * GateWay进行网关测试案例02
     *
     * @return
     */
    @GetMapping(value = "/pay/gateway/info")
    ResultData<String> getGatewayInfo();
}
