package com.hanshop.hanshopping_mall.repository;

import com.hanshop.hanshopping_mall.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<User, Long> {}