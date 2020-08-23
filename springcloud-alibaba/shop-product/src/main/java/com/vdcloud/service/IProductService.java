package com.vdcloud.service;

import com.vdcloud.entity.Product;

/**
 * @author gouyadong
 */
public interface IProductService {
    /**
     * 根据商品id查询商品信息
     *
     * @param pid 商品id
     * @return 返回商品id
     */
    Product findByPid(Integer pid);

    /**
     * 扣减库存
     *
     * @param pid 商品id
     * @param num 扣减数量
     */
    void reduceStock(Integer pid, Integer num);
}
