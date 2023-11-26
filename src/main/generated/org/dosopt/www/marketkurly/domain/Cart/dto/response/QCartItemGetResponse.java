package org.dosopt.www.marketkurly.domain.Cart.dto.response;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * org.dosopt.www.marketkurly.domain.Cart.dto.response.QCartItemGetResponse is a Querydsl Projection type for CartItemGetResponse
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QCartItemGetResponse extends ConstructorExpression<CartItemGetResponse> {

    private static final long serialVersionUID = 1187251407L;

    public QCartItemGetResponse(com.querydsl.core.types.Expression<org.dosopt.www.marketkurly.domain.Product.entity.DeliveryType> deliveryType, com.querydsl.core.types.Expression<String> productName, com.querydsl.core.types.Expression<Integer> price, com.querydsl.core.types.Expression<Integer> discountRate, com.querydsl.core.types.Expression<String> imageURL, com.querydsl.core.types.Expression<Integer> count) {
        super(CartItemGetResponse.class, new Class<?>[]{org.dosopt.www.marketkurly.domain.Product.entity.DeliveryType.class, String.class, int.class, int.class, String.class, int.class}, deliveryType, productName, price, discountRate, imageURL, count);
    }

}

