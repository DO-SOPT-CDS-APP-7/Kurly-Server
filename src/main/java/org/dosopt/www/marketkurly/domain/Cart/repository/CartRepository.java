package org.dosopt.www.marketkurly.domain.Cart.repository;
import org.dosopt.www.marketkurly.domain.Cart.entity.Cart;
import org.dosopt.www.marketkurly.domain.Cart.querydsl.CartCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUserId(Long userId);
}
