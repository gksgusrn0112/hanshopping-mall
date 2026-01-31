package com.hanshop.hanshopping_mall.api;

import com.hanshop.hanshopping_mall.dto.OrderRequestDto;
import com.hanshop.hanshopping_mall.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class OrderApiController {
    private final OrderService orderService;

    @PostMapping("/order")
    public String order(@RequestBody OrderRequestDto request) {
        orderService.order(request.getUserId(), request.getProductItemId(), request.getCount());
        return "주문 성공!";
    }
}