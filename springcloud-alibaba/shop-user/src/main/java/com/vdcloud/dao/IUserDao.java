package com.vdcloud.dao;

import com.vdcloud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDao extends JpaRepository<User, Integer> {
}
