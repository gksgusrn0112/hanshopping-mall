package com.hanshop.hanshopping_mall.service;

import com.hanshop.hanshopping_mall.domain.*;
import com.hanshop.hanshopping_mall.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ProductItemRepository productItemRepository;

    @Transactional
    public Long order(Long userId, Long productItemId, int count) {
        User user = memberRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("회원이 없습니다."));
        ProductItem productItem = productItemRepository.findById(productItemId)
                .orElseThrow(() -> new IllegalStateException("상품이 없습니다."));

        OrderItem orderItem = OrderItem.createOrderItem(productItem, productItem.getTotalPrice(), count);
        Order order = Order.createOrder(user, orderItem);

        orderRepository.save(order);
        return order.getId();
    }
}