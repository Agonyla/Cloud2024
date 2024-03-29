package com.agony;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Agony
 * @create 2024/3/20 20:09
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class Main83 {
    public static void main(String[] args) {
        SpringApplication.run(Main83.class, args);
    }
}
