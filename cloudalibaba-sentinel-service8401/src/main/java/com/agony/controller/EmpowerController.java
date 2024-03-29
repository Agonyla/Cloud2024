package com.agony.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Agony
 * @create 2024/3/27 15:34
 */
@RestController
@Slf4j
@Tag(name = "授权规则")
public class EmpowerController {

    /**
     * 授权规则测试
     *
     * @return
     */
    @GetMapping(value = "/sentinel/empower")
    public String requestSentinel(@RequestParam(value = "serverName", required = false) String serverName) {
        log.info("测试Sentinel授权规则empower");
        return "Sentinel授权规则";
    }

}
