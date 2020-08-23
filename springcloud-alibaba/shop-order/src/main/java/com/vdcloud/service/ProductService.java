package com.vdcloud.service;

import com.vdcloud.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author gouyadong
 */
@FeignClient(value = "service-product")
//@FeignClient(value = "service-product", fallback = ProductServiceFallBack.class)
public interface ProductService {

    @RequestMapping("/product/{pid}")
    Product findByPid(@PathVariable("pid") Integer pid);

    @GetMapping("/product/reduceStock")
    void reduceStock(@RequestParam("pid") Integer pid, @RequestParam("num") Integer num);
}
