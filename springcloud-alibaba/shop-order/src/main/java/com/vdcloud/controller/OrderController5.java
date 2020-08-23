package com.vdcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author gouyadong
 */
@RestController
@Slf4j
public class OrderController5 {

    public static void main(String[] args) {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("myconsumer-group");
        consumer.setNamesrvAddr("192.168.137.131:9876");

        try {
            consumer.subscribe("myTopic", "*");
            consumer.registerMessageListener((MessageListenerConcurrently) (list, consumeConcurrentlyContext) -> {
                MessageExt messageExt = list.get(0);
                byte[] body = messageExt.getBody();
                String msg = new String(body);
                System.out.println("接收到的消息:" + msg);
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            });
            consumer.start();
            System.out.println("Consumer started！");
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }
}
