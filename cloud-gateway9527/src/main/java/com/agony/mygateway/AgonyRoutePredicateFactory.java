package com.agony.mygateway;

import com.agony.enums.UserType;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Agony
 * @create 2024/3/20 14:36
 */
@Component
public class AgonyRoutePredicateFactory extends AbstractRoutePredicateFactory<AgonyRoutePredicateFactory.Config> {

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return new Predicate<ServerWebExchange>() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                String usertype = serverWebExchange.getRequest().getQueryParams().getFirst("usertype");
                if (usertype == null) {
                    return false;
                }
                UserType userType = UserType.getUserType(usertype);
                UserType configUserType = UserType.getUserType(config.usertype);
                return userType.getScore() >= configUserType.getScore();

            }
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList("usertype");
    }

    @Setter
    @Getter
    public static class Config {

        @NotEmpty
        private String usertype;
    }

    public AgonyRoutePredicateFactory() {
        super(AgonyRoutePredicateFactory.Config.class);
    }
}
