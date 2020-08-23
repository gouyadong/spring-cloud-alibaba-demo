package com.vdcloud.service;

import com.vdcloud.entity.Order;

/**
 * @author gouyadong
 */
public interface IOrderService {
    /**
     * 创建订单
     *
     * @param order 订单详情
     */
    void createOrder(Order order);

    Order createOrder(Integer pid);
}
