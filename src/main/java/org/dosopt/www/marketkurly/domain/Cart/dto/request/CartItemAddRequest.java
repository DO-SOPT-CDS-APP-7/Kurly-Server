package org.dosopt.www.marketkurly.domain.Cart.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CartItemAddRequest {
    @Schema(description = "상품 아이디")
    private Long productId;

    @Schema(description = "상품 개수")
    private int count;
}
