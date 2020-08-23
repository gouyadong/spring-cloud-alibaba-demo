//package com.vdong.com.vdong.config;
//
//
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//import java.util.List;
//
///**
// * @author gouyadong
// */
//@Component
//public class LogGatewayFilterFactory extends AbstractGatewayFilterFactory<LogGatewayFilterFactory.Config> {
//    /**
//     * 构造函数
//     */
//    public LogGatewayFilterFactory() {
//        super(LogGatewayFilterFactory.Config.class);
//    }
//
//    /**
//     * 过滤器逻辑
//     *
//     * @param config
//     * @return
//     */
//    @Override
//    public GatewayFilter apply(LogGatewayFilterFactory.Config config) {
//        return (exchange, chain) -> {
//            if (config.isCacheLog()) {
//                System.out.println("CacheLog已经开启了...");
//            }
//            if (config.isConsoleLog()) {
//                System.out.println("ConsoleLog已经开启了...");
//            }
//            return chain.filter(exchange);
//        };
//    }
//
//    /**
//     * 读取配置文件中的参数，赋值到配置类中
//     *
//     * @return
//     */
//    @Override
//    public List<String> shortcutFieldOrder() {
//        return Arrays.asList("consoleLog", "cacheLog");
//    }
//
//    @Data
//    @NoArgsConstructor
//    public static class Config {
//        private boolean consoleLog;
//        private boolean cacheLog;
//    }
//}
