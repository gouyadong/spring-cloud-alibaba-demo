//package com.vdong.com.vdong.config;
//
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
///**
// * @author gouyadong
// */
////@Component
//public class AuthGlobalFilter implements GlobalFilter, Ordered {
//    /**
//     * 完成判断逻辑
//     *
//     * @param exchange
//     * @param chain
//     * @return
//     */
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        String token = exchange.getRequest().getQueryParams().getFirst("token");
//        if (StringUtils.isBlank(token)) {
//            System.out.println("鉴权失败,请求未携带token...");
//            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//            return exchange.getResponse().setComplete();
//        }
//        //调用chain filter继续向下游执行
//        return chain.filter(exchange);
//    }
//
//    @Override
//    public int getOrder() {
//        return 0;
//    }
//}
