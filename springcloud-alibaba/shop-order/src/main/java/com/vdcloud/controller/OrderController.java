package com.vdcloud.controller;

import com.alibaba.fastjson.JSON;
import com.vdcloud.entity.Order;
import com.vdcloud.entity.Product;
import com.vdcloud.service.IOrderService;
import com.vdcloud.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author gouyadong
 */
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private IOrderService orderService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private ProductService productService;

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

//    @GetMapping("/order/prod/{pid}")
//    public Order order(@PathVariable("pid") Integer pid) {
//        log.info("接收到{}号商品的下单请求,接下来调用商品微服务查询此商品信息", pid);
//
////        Product product = restTemplate.getForObject("http://service-product/product/" + pid, Product.class);
//
//        Product product = productService.findByPid(pid);
//        log.info("查询到{}号商品的信息,内容是:{}", pid, JSON.toJSONString(product));
//
//        Order order = new Order();
//
//        order.setPid(pid);
//        order.setPname(product.getPname());
//        order.setPprice(product.getPprice());
//
//        order.setUsername("利斯");
//        order.setUid(111);
//        order.setNumber(1);
//        orderService.createOrder(order);
//        log.info("创建订单成功,订单信息为:{}", JSON.toJSONString(order));
//        return order;
//    }

    @GetMapping("/order/prod1/{pid}")
    public Order order(@PathVariable("pid") Integer pid) {
        log.info("接收到{}号商品的下单请求,接下来调用商品微服务查询此商品信息", pid);

//        Product product = restTemplate.getForObject("http://service-product/product/" + pid, Product.class);

        Product product = productService.findByPid(pid);
        log.info("查询到{}号商品的信息,内容是:{}", pid, JSON.toJSONString(product));
        if (product.getPid() == -1) {
            Order order = new Order();
            order.setPname("下单失败");
            return order;
        }

        Order order = new Order();

        order.setPid(pid);
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());

        order.setUsername("利斯");
        order.setUid(111);
        order.setNumber(1);
//        orderService.createOrder(order);
        log.info("创建订单成功,订单信息为:{}", JSON.toJSONString(order));
        rocketMQTemplate.convertAndSend("order-topic", JSON.toJSONString(order));
        return order;
    }

}
