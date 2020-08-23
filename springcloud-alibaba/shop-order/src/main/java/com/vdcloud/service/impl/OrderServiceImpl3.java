package com.vdcloud.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.vdcloud.service.BlockHandler;
import com.vdcloud.service.FallBackHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author gouyadong
 */
@Service
@Slf4j
public class OrderServiceImpl3 {
    int i = 0;

    @SentinelResource(value = "message",
            blockHandlerClass = BlockHandler.class,
            blockHandler = "blockHandler",//指定发生BlockException时进入的方法
            fallbackClass = FallBackHandler.class,
            fallback = "fallback")//指定发生Throwable时进入的方法
    public String message() {
        i++;
        if (i % 3 == 0) {
            throw new RuntimeException();
        }
        System.out.println("message");
        return "message";
    }
}
