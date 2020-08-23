package com.vdcloud.config;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author gouyadong
 */
@Component
public class RequestOriginParserDefinition implements RequestOriginParser {

    @Override
    public String parseOrigin(HttpServletRequest request) {
        String serviceName = request.getParameter("serviceName");
        return serviceName;
    }
}

