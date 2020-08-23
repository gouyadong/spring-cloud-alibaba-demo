package com.vdcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gouyadong
 */
@RestController
@Slf4j
public class OrderController4 {

    public static void main(String[] args) {
        DefaultMQProducer producer = new DefaultMQProducer("myproducer-group");
        producer.setNamesrvAddr("192.168.137.131:9876");
        try {
            producer.start();
            Message message = new Message("myTopic", "myTag", "Hello World".getBytes());
            SendResult send = producer.send(message, 10000);
            System.out.println("发送消息返回结果:" + send);
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        } finally {
            producer.shutdown();
        }
    }
}
