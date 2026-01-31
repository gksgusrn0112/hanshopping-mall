package com.hanshop.hanshopping_mall.dto;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderRequestDto {
    private Long userId;
    private Long productItemId;
    private int count;
}