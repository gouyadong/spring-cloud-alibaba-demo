package com.vdcloud.dao;

import com.vdcloud.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductDao extends JpaRepository<Product, Integer> {
}
