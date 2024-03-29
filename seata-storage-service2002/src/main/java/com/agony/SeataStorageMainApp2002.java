package com.agony;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Agony
 * @create 2024/3/28 21:44
 */
@SpringBootApplication
@MapperScan("com.agony.mapper")
@EnableDiscoveryClient
@EnableFeignClients
public class SeataStorageMainApp2002 {
    public static void main(String[] args) {
        SpringApplication.run(SeataStorageMainApp2002.class, args);
    }
}
