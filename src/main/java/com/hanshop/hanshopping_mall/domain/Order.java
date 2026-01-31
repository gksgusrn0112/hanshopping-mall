package com.hanshop.hanshopping_mall.domain;

import jakarta.persistence.*; // 여기에 Id가 포함되어 있어
import lombok.Getter;
import lombok.Setter;
// import org.springframework.data.annotation.Id; <-- 이거 삭제!

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {

    @Id // jakarta.persistence.Id가 사용됨
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    private LocalDateTime orderDate;
    private String status;
}