package com.vdcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.vdcloud.service.impl.OrderServiceImpl3;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gouyadong
 */
@RestController
@Slf4j
public class OrderController3 {

    @Autowired
    private OrderServiceImpl3 impl3;

    @Value("${spring.application.name}")
    private String applicationName;

    @GetMapping("/order/message1")
    public String message1() {
        impl3.message();
        return "message1";
    }

    int i = 0;

    @GetMapping("/order/message2")
    public String message2() {
        i++;
        if (i % 3 == 0) {
            throw new RuntimeException();
        }
//        impl3.message();
        return "message2";
    }

    @GetMapping("/order/message3")
    @SentinelResource("message3")//注意这里必须使用这个注解标识,热点规则不生效
    public String message3(String name, Integer age) {
        return name + age;
    }

    @GetMapping("/order/message4")
    public String message4() {
        log.info("applicationName:{}", applicationName);
        return impl3.message();
    }
}
