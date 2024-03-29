package com.agony.mygateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author Agony
 * @create 2024/3/20 19:21
 */
@Component
@Slf4j
public class MyGlobalFilter2 implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        long startTime = System.currentTimeMillis();
        System.out.println("============ startTime2 = " + startTime);
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            long endTime = System.currentTimeMillis();
            System.out.println("============ endTime2 = " + endTime);
            log.info("endTime2 - startTime2 = " + String.valueOf(endTime - startTime) + "ms");
        }));
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
