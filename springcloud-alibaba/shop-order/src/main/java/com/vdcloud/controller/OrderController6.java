package com.vdcloud.controller;

import com.vdcloud.entity.Order;
import com.vdcloud.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gouyadong
 */
@RestController
@Slf4j
public class OrderController6 {
    @Autowired
    private IOrderService orderService;

    @GetMapping("/order/prod/{pid}")
    public Order order(@PathVariable("pid") Integer pid) {
        log.info("接收到{}号商品的下单请求,接下来调用商品微服务查询此商品信息", pid);
        return orderService.createOrder(pid);
    }

    @GetMapping("/order/message")
    public String message() {
        return "高并发下的问题测试";
    }

}
