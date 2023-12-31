package org.dosopt.www.marketkurly.domain.Cart.repository;

import org.dosopt.www.marketkurly.domain.Cart.entity.CartItem;
import org.dosopt.www.marketkurly.domain.Cart.querydsl.CartCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long>, CartCustomRepository {
    CartItem findByCartIdAndProductId(Long cartId, Long productId);
    CartItem findByCartId(Long cartId);

}

