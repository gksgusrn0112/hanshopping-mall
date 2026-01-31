package com.hanshop.hanshopping_mall.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
// import org.springframework.core.annotation.Order; <-- 이거 삭제! (범인)
// import org.springframework.data.annotation.Id;    <-- 이거 삭제!

@Entity
@Getter @Setter
public class OrderItem {

    @Id // jakarta.persistence.Id가 사용됨
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order; // 이제 같은 패키지의 Order 엔티티를 잘 인식할 거야

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_item_id")
    private ProductItem productItem;

    private int orderPrice;
    private int count;
}