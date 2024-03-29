package com.agony.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swagger3Config {
    @Bean
    public GroupedOpenApi PayApi() {
        return GroupedOpenApi.builder().group("消费微服务模块").pathsToMatch("/pay/**").build();
    }

    @Bean
    public GroupedOpenApi ConsumerApi() {
        return GroupedOpenApi.builder().group("客户微服务模块").pathsToMatch("/consumer/**", "/consumers").build();
    }

    @Bean
    public GroupedOpenApi FeignApi() {
        return GroupedOpenApi.builder().group("客户Feign微服务模块").pathsToMatch("/feign/**").build();
    }

    @Bean
    public GroupedOpenApi GateWayApi() {
        return GroupedOpenApi.builder().group("网关微服务模块").pathsToMatch("/gateway/**").build();
    }

    @Bean
    public GroupedOpenApi AlibabaPayApi() {
        return GroupedOpenApi.builder().group("Alibaba消费微服务模块").pathsToMatch("/pay/nacos/**").build();
    }

    @Bean
    public GroupedOpenApi AlibabaConsumerApi() {
        return GroupedOpenApi.builder().group("Alibaba客户微服务模块").pathsToMatch("/consumer/pay/nacos/**").build();
    }

    @Bean
    public GroupedOpenApi SentinelApi() {
        return GroupedOpenApi.builder().group("Sentinel模块").pathsToMatch("/sentinel/**").build();
    }


    @Bean
    public GroupedOpenApi SeataApi() {
        return GroupedOpenApi.builder().group("Seata模块").pathsToMatch("/seata/**").build();
    }

    @Bean
    public GroupedOpenApi OtherApi() {
        return GroupedOpenApi.builder().group("其它微服务模块").pathsToMatch("/other/**", "/others").build();
    }


    /*@Bean
    public GroupedOpenApi CustomerApi()
    {
        return GroupedOpenApi.builder().group("客户微服务模块").pathsToMatch("/customer/**", "/customers").build();
    }*/

    @Bean
    public OpenAPI docsOpenApi() {
        return new OpenAPI()
                .info(new Info().title("cloud2024")
                        .description("通用设计rest")
                        .version("v1.0"))
                .externalDocs(new ExternalDocumentation()
                        .description("www.baidu.com")
                        .url("https://yiyan.baidu.com/"));
    }
}
