package com.hanshop.hanshopping_mall.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(nullable = false)
    private String name; // 상품명 (예: 기모 후드티)

    @Column(nullable = false)
    private int price; // 기본 가격

    @Lob // 긴 텍스트 저장할 때 씀
    private String description; // 상품 설명

    private String thumbnailUrl; // 썸네일 이미지 주소

    @CreationTimestamp
    private LocalDateTime createdAt; // 등록일

    // ★ 중요: 상품(1)이 사라지면 옵션(N)들도 다 사라지게 설정 (Cascade)
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductItem> productItems = new ArrayList<>();

    // 생성자
    public Product(String name, int price, String description, String thumbnailUrl) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.thumbnailUrl = thumbnailUrl;
    }
}