package com.hanshop.hanshopping_mall;

import com.hanshop.hanshopping_mall.domain.*;
import com.hanshop.hanshopping_mall.repository.*;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class InitDb {
    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        private final MemberRepository memberRepository;
        private final ProductRepository productRepository;
        private final ProductItemRepository productItemRepository;

        public void dbInit() {
            User user = new User();
            user.setName("현구");
            user.setEmail("test@test.com");
            memberRepository.save(user);

            Product product = new Product();
            product.setName("강남대 티셔츠");
            product.setPrice(10000);
            productRepository.save(product);

            ProductItem item = new ProductItem();
            item.setProduct(product);
            item.setOptionName("L");
            item.setStockQuantity(100);
            productItemRepository.save(item);
        }
    }
}