package org.dosopt.www.marketkurly.domain.Cart.dto.response;


import com.querydsl.core.annotations.QueryProjection;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.dosopt.www.marketkurly.domain.Cart.entity.CartItem;
import org.dosopt.www.marketkurly.domain.Product.entity.DeliveryType;

@Data
public class CartItemGetResponse {
    @Schema(description = "배송")
    DeliveryType deliveryType;

    @Schema(description = "상품명")
    String productName;

    @Schema(description = "원가")
    Integer price;

    @Schema(description = "할인율")
    Integer discountRate;

    @Schema(description = "상품 이미지", nullable = true)
    String imageURL;

    @Schema(description = "담은 개수")
    Integer count;

    @QueryProjection
    public CartItemGetResponse(DeliveryType deliveryType, String productName, Integer price, Integer discountRate, String imageURL, Integer count){
        this.deliveryType = deliveryType;
        this.productName = productName;
        this.price = price;
        this.discountRate = discountRate;
        this.imageURL = imageURL;
        this.count = count;
    }

    public static CartItemGetResponse of(CartItem cartItem) {
        return new CartItemGetResponse(cartItem.getProduct().getDeliveryType(),
                                       cartItem.getProduct().getProductName(),
                                       cartItem.getProduct().getPrice(),
                                       cartItem.getProduct().getDiscountRate(),
                                       cartItem.getProduct().getImageURL(),
                                       cartItem.getCount());
    }
}
