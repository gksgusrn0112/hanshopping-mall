package com.hanshop.hanshopping_mall.repository;

import com.hanshop.hanshopping_mall.domain.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
}