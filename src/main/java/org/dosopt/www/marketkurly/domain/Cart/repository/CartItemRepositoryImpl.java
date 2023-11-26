package org.dosopt.www.marketkurly.domain.Cart.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.dosopt.www.marketkurly.domain.Cart.dto.response.CartItemGetResponse;
import org.dosopt.www.marketkurly.domain.Cart.dto.response.QCartItemGetResponse;
import org.dosopt.www.marketkurly.domain.Cart.querydsl.CartCustomRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.dosopt.www.marketkurly.domain.Cart.entity.QCartItem.cartItem;

@Repository
@RequiredArgsConstructor
public class CartItemRepositoryImpl implements CartCustomRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<CartItemGetResponse> findByCartId(Long cartId) {
        return jpaQueryFactory
                .select(new QCartItemGetResponse(
                        cartItem.product.deliveryType,
                        cartItem.product.productName,
                        cartItem.product.price,
                        cartItem.product.discountRate,
                        cartItem.product.imageURL, cartItem.count))
                .from(cartItem)
                .where(cartItem.cart.id.eq(cartId))
                .fetch();
        }


}
