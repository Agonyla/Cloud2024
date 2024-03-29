package com.agony.controller;

import com.agony.service.FlowLimitService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author Agony
 * @create 2024/3/25 21:15
 */
@RestController
public class FlowLimitController {

    @GetMapping("/sentinel/testA")
    public String testA() {
        return "------testA";
    }

    @GetMapping("/sentinel/testB")
    public String testB() {
        return "------testB";
    }

    /**
     * 流控-链路演示demo
     * C和D两个请求都访问flowLimitService.common()方法，阈值到达后对C限流，对D不管
     */
    @Resource
    private FlowLimitService flowLimitService;

    @GetMapping("/sentinel/testC")
    public String testC() {
        flowLimitService.common();
        return "------testC";
    }

    @GetMapping("/sentinel/testD")
    public String testD() {
        flowLimitService.common();
        return "------testD";
    }


    @GetMapping("/sentinel/testE")
    public String testE() {
        System.out.println(System.currentTimeMillis() + "      testE,排队等待");
        return "------testE";
    }


    /**
     * 新增熔断规则-慢调用比例
     *
     * @return
     */
    @GetMapping("/sentinel/testF")
    public String testF() {
        //暂停几秒钟线程
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("----测试:新增熔断规则-慢调用比例 ");
        return "------testF 新增熔断规则-慢调用比例";
    }

    /**
     * 新增熔断规则-异常比例
     *
     * @return
     */
    @GetMapping("/sentinel/testG")
    public String testG() {
        System.out.println("----测试:新增熔断规则-异常比例 ");
        int age = 10 / 0;
        return "------testG,新增熔断规则-异常比例 ";
    }

}