package com.hanshop.hanshopping_mall.repository;

import com.hanshop.hanshopping_mall.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);
}