package com.hanshop.hanshopping_mall.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class OrderItem {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_item_id")
    private ProductItem productItem;

    private int orderPrice;
    private int count;

    // ==생성 메서드== //
    public static OrderItem createOrderItem(ProductItem productItem, int orderPrice, int count) {
        OrderItem orderItem = new OrderItem();
        orderItem.setProductItem(productItem);
        orderItem.setOrderPrice(orderPrice);
        orderItem.setCount(count);

        productItem.removeStock(count); // 재고 감소 로직 호출
        return orderItem;
    }
}