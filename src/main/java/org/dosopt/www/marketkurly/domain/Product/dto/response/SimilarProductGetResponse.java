package org.dosopt.www.marketkurly.domain.Product.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import org.dosopt.www.marketkurly.domain.Product.entity.DeliveryType;
import org.dosopt.www.marketkurly.domain.Product.entity.Product;

public record SimilarProductGetResponse(
      @Schema(description = "배송")
      String deliveryType,
      @Schema(description = "상품명")
      String productName,
      @Schema(description = "원가")
      Integer originalPrice,
      @Schema(description = "상품 이미지")
      String imageURL
) {
   public static SimilarProductGetResponse of (Product product) {
      return new SimilarProductGetResponse (
            product.getDeliveryType().getDelivery(),
            product.getProductName(),
            product.getPrice(),
            product.getImageURL()
      );
   }
}
