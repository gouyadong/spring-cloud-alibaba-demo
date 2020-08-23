package com.vdcloud.service.impl;

import com.vdcloud.entity.Product;
import com.vdcloud.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author gouyadong
 */

@Component
@Slf4j
public class ProductServiceFallBack implements ProductService {
    @Override
    public Product findByPid(Integer pid) {
        Product product = new Product();
        product.setPid(-1);
        return product;
    }

    @Override
    public void reduceStock(Integer pid, Integer num) {
        return;
    }
}
