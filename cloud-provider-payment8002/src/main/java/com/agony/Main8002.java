package com.agony;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.agony.mapper")
@EnableDiscoveryClient
public class Main8002 {
    public static void main(String[] args) {
        SpringApplication.run(Main8002.class, args);
    }
}