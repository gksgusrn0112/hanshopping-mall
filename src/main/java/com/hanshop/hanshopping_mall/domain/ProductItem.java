package com.hanshop.hanshopping_mall.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ProductItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_item_id")
    private Long id;

    // ★ 어떤 상품의 옵션인지 연결 (FK)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(nullable = false)
    private String optionName; // 옵션명 (예: Red / L)

    private int additionalPrice; // 추가 금액 (기본값 0)

    @Column(nullable = false)
    private int stockQuantity; // 재고 수량

    // 생성자
    public ProductItem(Product product, String optionName, int additionalPrice, int stockQuantity) {
        this.product = product;
        this.optionName = optionName;
        this.additionalPrice = additionalPrice;
        this.stockQuantity = stockQuantity;
    }

    // 재고 줄이는 비즈니스 로직 (나중에 써먹을 거야!)
    public void removeStock(int count) {
        int restStock = this.stockQuantity - count;
        if (restStock < 0) {
            throw new RuntimeException("재고가 부족합니다.");
        }
        this.stockQuantity = restStock;
    }
}