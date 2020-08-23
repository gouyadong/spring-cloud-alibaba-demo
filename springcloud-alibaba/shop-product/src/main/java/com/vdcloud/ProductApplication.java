package com.vdcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author gouyadong
 */
@SpringBootApplication //(exclude = GlobalTransactionAutoConfiguration.class)
@EnableDiscoveryClient
@EnableFeignClients
public class ProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class);
    }
}
