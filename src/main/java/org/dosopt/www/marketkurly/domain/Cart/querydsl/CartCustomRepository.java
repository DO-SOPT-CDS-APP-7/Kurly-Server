package org.dosopt.www.marketkurly.domain.Cart.querydsl;

import org.dosopt.www.marketkurly.domain.Cart.dto.response.CartItemGetResponse;

import java.util.List;

public interface CartCustomRepository {
    List<CartItemGetResponse> findByCartId(Long cartId);
}
