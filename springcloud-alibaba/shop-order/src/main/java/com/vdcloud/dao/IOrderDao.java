package com.vdcloud.dao;

import com.vdcloud.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderDao extends JpaRepository<Order, Integer> {
}
