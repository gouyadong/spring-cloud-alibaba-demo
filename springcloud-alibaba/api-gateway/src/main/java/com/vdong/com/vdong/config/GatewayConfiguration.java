//package com.vdong.com.vdong.config;
//
//import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayFlowRule;
//import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayRuleManager;
//import com.alibaba.csp.sentinel.adapter.gateway.sc.SentinelGatewayFilter;
//import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.BlockRequestHandler;
//import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.GatewayCallbackManager;
//import com.alibaba.csp.sentinel.adapter.gateway.sc.exception.SentinelGatewayBlockExceptionHandler;
//import org.springframework.beans.factory.ObjectProvider;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.codec.ServerCodecConfigurer;
//import org.springframework.web.reactive.function.BodyInserters;
//import org.springframework.web.reactive.function.server.ServerResponse;
//import org.springframework.web.reactive.result.view.ViewResolver;
//
//import javax.annotation.PostConstruct;
//import java.util.*;
//
///**
// * @author gouyadong
// */
//@Configuration
//public class GatewayConfiguration {
//
//    private final List<ViewResolver> viewResolvers;
//
//    private final ServerCodecConfigurer serverCodecConfigurer;
//
//    public GatewayConfiguration(ObjectProvider<List<ViewResolver>> viewResolverProvider, ServerCodecConfigurer serverCodecConfigurer) {
//        this.viewResolvers = viewResolverProvider.getIfAvailable(Collections::emptyList);
//        this.serverCodecConfigurer = serverCodecConfigurer;
//    }
//
//    /**
//     * 初始化一个限流的过滤器
//     *
//     * @return
//     */
//    @Bean
//    @Order(Ordered.HIGHEST_PRECEDENCE)
//    public GlobalFilter sentinelGatewayFilter() {
//        return new SentinelGatewayFilter();
//    }
//
//    /**
//     * 配置初始化的限流参数
//     */
//    @PostConstruct
//    public void initGatewayRules() {
//        Set<GatewayFlowRule> rules = new HashSet<>();
//        rules.add(new GatewayFlowRule("product_route").setCount(1).setIntervalSec(1));
//        GatewayRuleManager.loadRules(rules);
//    }
//
//    /**
//     * 配置限流的异常处理器
//     *
//     * @return
//     */
//    @Bean
//    @Order(Ordered.HIGHEST_PRECEDENCE)
//    public SentinelGatewayBlockExceptionHandler sentinelGatewayBlockExceptionHandler() {
//        return new SentinelGatewayBlockExceptionHandler(viewResolvers, serverCodecConfigurer);
//    }
//
//    /**
//     * 自定义限流异常页面
//     */
//    @PostConstruct
//    public void initBlockHandlers() {
//        BlockRequestHandler blockRequestHandler = (serverWebExchange, throwable) -> {
//            Map map = new HashMap(2);
//            map.put("code", 0);
//            map.put("message", "接口被限流了...");
//            return ServerResponse.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8).body(BodyInserters.fromObject(map));
//        };
//        GatewayCallbackManager.setBlockHandler(blockRequestHandler);
//    }
//}