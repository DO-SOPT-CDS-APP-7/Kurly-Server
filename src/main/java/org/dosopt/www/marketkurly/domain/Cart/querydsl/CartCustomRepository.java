package org.dosopt.www.marketkurly.domain.Cart.querydsl;


import org.dosopt.www.marketkurly.domain.Cart.dto.response.CartItemGetResponse;
import org.dosopt.www.marketkurly.domain.Cart.entity.CartItem;

import java.util.List;

public interface CartCustomRepository {

    void deleteAllByCart_Id(Long cartId);

    List<CartItemGetResponse> findItemsByCartId(Long cartId);

}
