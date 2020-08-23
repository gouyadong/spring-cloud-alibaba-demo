package com.vdcloud.controller;

import com.alibaba.fastjson.JSON;
import com.vdcloud.entity.Product;
import com.vdcloud.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gouyadong
 */
@RestController
@Slf4j
public class ProductController {

    @Autowired
    private IProductService productService;

    @Value("${config.appName}")
    private String appName;

    @RequestMapping("/product/{pid}")
    public Product product(@PathVariable("pid") Integer pid) {
        log.info("接下来查询{}号商品信息", pid);
        Product product = productService.findByPid(pid);
        log.info("商品内容查询成功,内容为：{}", JSON.toJSONString(product));
        log.info("appName:{}", appName);
        return product;
    }

    @GetMapping("/product/reduceStock")
    public void reduceStock(Integer pid, Integer num) {
        productService.reduceStock(pid, num);
    }
}
