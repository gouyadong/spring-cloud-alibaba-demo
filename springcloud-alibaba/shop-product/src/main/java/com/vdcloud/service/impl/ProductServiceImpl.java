package com.vdcloud.service.impl;

import com.vdcloud.dao.IProductDao;
import com.vdcloud.entity.Product;
import com.vdcloud.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author gouyadong
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductServiceImpl implements IProductService {

    private final IProductDao productDao;

    /**
     * 根据商品id查询商品信息
     *
     * @param pid 商品id
     * @return 返回商品id
     */
    @Override
    public Product findByPid(Integer pid) {
        return productDao.findById(pid).get();
    }

    /**
     * 扣减库存
     *
     * @param pid 商品id
     * @param num 扣减数量
     */
    @Override
    public void reduceStock(Integer pid, Integer num) {
        Product product = productDao.findById(pid).get();
        if (product.getStock() < num) {
            throw new RuntimeException("库存不足！");
        }
//        int i = 1 / 0;
        product.setStock(product.getStock() - num);
        productDao.save(product);
    }
}
