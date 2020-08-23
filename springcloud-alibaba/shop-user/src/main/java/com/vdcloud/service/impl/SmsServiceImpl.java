package com.vdcloud.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @author gouyadong
 */
@Service
@Slf4j
@RocketMQMessageListener(topic = "order-topic", consumerGroup = "shop-user")
public class SmsServiceImpl implements RocketMQListener<String> {

    @Override
    public void onMessage(String s) {
        log.info("接收到一条订单消息:{}", s);
    }
}
