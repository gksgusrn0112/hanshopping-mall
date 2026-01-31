package com.hanshop.hanshopping_mall.service;

import com.hanshop.hanshopping_mall.domain.*;
import com.hanshop.hanshopping_mall.repository.MemberRepository;
import com.hanshop.hanshopping_mall.repository.OrderRepository;
import com.hanshop.hanshopping_mall.repository.ProductItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) // 데이터 변경이 없는 조회 메서드에 최적화
@RequiredArgsConstructor // final이 붙은 필드에 대한 생성자를 자동으로 만들어줌
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ProductItemRepository productItemRepository;

    /**
     * 주문 하기
     */
    @Transactional // 데이터가 변경되는 로직이므로 쓰기용 트랜잭션 적용
    public Long order(Long userId, Long productItemId, int count) {

        // 1. 엔티티 조회 (회원과 상품 아이템 정보를 DB에서 가져옴)
        User user = memberRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 회원입니다."));
        ProductItem productItem = productItemRepository.findById(productItemId)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 상품입니다."));

        // 2. 주문상품 생성 (중요: 이 내부에서 productItem.removeStock()이 호출되어야 함)
        OrderItem orderItem = OrderItem.createOrderItem(productItem, productItem.getPrice(), count);

        // 3. 주문 생성 (누가, 어떤 상품들을 주문했는지 정보 결합)
        Order order = Order.createOrder(user, orderItem);

        // 4. 주문 저장
        // OrderItem은 Order에 cascade = CascadeType.ALL 설정을 했기 때문에 따로 저장 안 해도 됨!
        orderRepository.save(order);

        return order.getId();
    }

    /**
     * 주문 취소
     */
    @Transactional
    public void cancelOrder(Long orderId) {
        // 주문 엔티티 조회
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 주문입니다."));
        // 주문 취소 로직 호출 (이 안에 재고를 다시 늘리는 로직이 포함됨)
        order.cancel();
    }

    // 주문 검색이나 전체 조회가 필요하다면 여기에 메서드 추가
}