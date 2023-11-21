package org.dosopt.www.marketkurly.domain.Cart.repository;

import org.dosopt.www.marketkurly.domain.Cart.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemJpaRepository extends JpaRepository<CartItem, Long> {
    CartItem findByCartIdAndProductId(Long cartId, Long productId);
}
