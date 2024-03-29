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
 * @create 2024/3/20 19:06
 */
@Component
@Slf4j
public class MyGlobalFilter implements GlobalFilter, Ordered {


    /**
     * 实现借口调用时长统计
     *
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        long startTime = System.currentTimeMillis();
        System.out.println("============ startTime = " + startTime);
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            long endTime = System.currentTimeMillis();
            System.out.println("============ endTime = " + endTime);
            System.out.println("============ costTime = " + (endTime - startTime) + " ms");
        }));
    }

    /**
     * 优先级
     *
     * @return 返回值越小优先级越高
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
