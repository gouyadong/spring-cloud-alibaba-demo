package com.vdcloud.service.impl;

import com.alibaba.fastjson.JSON;
import com.vdcloud.dao.IOrderDao;
import com.vdcloud.entity.Order;
import com.vdcloud.entity.Product;
import com.vdcloud.service.IOrderService;
import com.vdcloud.service.ProductService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author gouyadong
 */
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderServiceImpl implements IOrderService {

    private final IOrderDao orderDao;

    private final ProductService productService;

    private final RocketMQTemplate rocketMQTemplate;

    /**
     * 创建订单
     *
     * @param order 订单详情
     */
    @Override
    public void createOrder(Order order) {
        orderDao.save(order);
    }

    @GlobalTransactional
    @Override
    public Order createOrder(Integer pid) {
        //查询商品信息
        Product product = productService.findByPid(pid);

        log.info("查询到{}号商品的信息,内容是:{}", pid, JSON.toJSONString(product));
        //创建订单
        Order order = new Order();
        order.setPid(pid);
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setUsername("ailis");
        order.setUid(1);
        order.setNumber(2);
        orderDao.save(order);
        log.info("创建订单成功,订单信息为:{}", JSON.toJSONString(order));
        //扣减库存
        productService.reduceStock(pid, order.getNumber());
        //订单通知
        rocketMQTemplate.convertAndSend("order-topic", JSON.toJSONString(order));
        return order;
    }
}
