package com.agony.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Agony
 * @create 2024/3/27 15:03
 */
@RestController
@Slf4j
@Tag(name = "SentinelResource测试")
public class RateLimitController {

    /**
     * 按默认限流返回
     *
     * @return
     */
    @GetMapping("/sentinel/rateLimit/byUrl")
    @Operation(summary = "默认限流返回")
    public String byUrl() {
        return "按rest地址限流测试OK";
    }

    /**
     * 自定义限流返回
     *
     * @return
     */
    @GetMapping("/sentinel/rateLimit/byResource")
    @SentinelResource(value = "byResourceSentinelResource", blockHandler = "handleException")
    @Operation(summary = "自定义限流返回")
    public String byResource() {
        return "按资源名称SentinelResource限流测试OK";
    }

    public String handleException(BlockException exception) {
        log.info("🥹🥹🥹触发了限流🥹🥹🥹");
        return "服务不可用@SentinelResource启动" + "\t" + "o(╥﹏╥)o";
    }


    /**
     * 自定义限流返回 + 服务降级处理
     *
     * @param p1
     * @return
     */
    @GetMapping("/sentinel/rateLimit/doAction/{p1}")
    @SentinelResource(value = "doActionSentinelResource",
            blockHandler = "doActionBlockHandler", fallback = "doActionFallback")
    @Operation(summary = "默认限流返回 + 服务降级处理")
    public String doAction(@PathVariable("p1") Integer p1) {
        if (p1 == 0) {
            throw new RuntimeException("p1等于零直接异常");
        }
        return "doAction";
    }

    public String doActionBlockHandler(@PathVariable("p1") Integer p1, BlockException e) {
        log.error("sentinel配置自定义限流了:{}", e);
        return "sentinel配置自定义限流了";
    }

    public String doActionFallback(@PathVariable("p1") Integer p1, Throwable e) {
        log.error("程序逻辑异常了:{}", e);
        return "程序逻辑异常了" + "\t" + e.getMessage();
    }


    /**
     * 热点参数限流
     *
     * @param p1 QPS超过 1 立马限流
     * @param p2
     * @return
     */
    @GetMapping("/sentinel/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "dealHandler_testHotKey")
    @Operation(summary = "热点参数限流")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        return "------testHotKey";
    }

    public String dealHandler_testHotKey(String p1, String p2, BlockException exception) {
        return "-----dealHandler_testHotKey";
    }


    /**
     * 热点参数限流三个参数
     *
     * @param p1
     * @param p2
     * @param p3
     * @return
     */
    @GetMapping("/sentinel/testHotKey2")
    @SentinelResource(value = "testHotKey2", blockHandler = "dealHandler_testHotKey2")
    @Operation(summary = "热点参数限流三个参数")
    public String testHotKey2(@RequestParam(value = "p1", required = false) String p1,
                              @RequestParam(value = "p2", required = false) String p2,
                              @RequestParam(value = "p3", required = false) String p3) {
        return "------testHotKey";
    }

    public String dealHandler_testHotKey2(String p1, String p2, String p3, BlockException exception) {
        return "-----dealHandler_testHotKey";
    }
}
