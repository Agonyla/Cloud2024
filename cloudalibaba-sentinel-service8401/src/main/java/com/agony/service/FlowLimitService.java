package com.agony.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * @author Agony
 * @create 2024/3/25 21:44
 */
@Service
public class FlowLimitService {
    @SentinelResource(value = "common")
    public void common() {
        System.out.println("------FlowLimitService come in");
    }
}
