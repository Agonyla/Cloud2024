package com.agony.handler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Agony
 * @create 2024/3/27 15:37
 */
@Component
@Slf4j
public class MyRequestOriginParser implements RequestOriginParser {


    /**
     * 获取请求参数 serverName
     *
     * @param httpServletRequest
     * @return
     */
    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
        String serverName = httpServletRequest.getParameter("serverName");
        log.info("serverName = {}", serverName);
        return serverName;
    }
}
