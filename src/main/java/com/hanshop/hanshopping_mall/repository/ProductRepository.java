package com.hanshop.hanshopping_mall.repository;

import com.hanshop.hanshopping_mall.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}