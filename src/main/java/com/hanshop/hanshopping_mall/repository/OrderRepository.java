package com.hanshop.hanshopping_mall.repository;

import com.hanshop.hanshopping_mall.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {}