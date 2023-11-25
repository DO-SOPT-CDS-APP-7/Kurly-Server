package org.dosopt.www.marketkurly.domain.Product.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import org.dosopt.www.marketkurly.domain.Product.entity.DeliveryType;
import org.dosopt.www.marketkurly.domain.Product.entity.Product;

import java.text.DecimalFormat;

public record ProductGetResponse (
      @Schema(description = "배송")
      String deliveryType,
      @Schema(description = "상품명")
      String productName,
      @Schema(description = "할인율")
      Integer discountRate,
      @Schema(description = "원가")
      Integer originalPrice,
      @Schema(description = "할인된 금액(원)")
      String discountedPrice,
      @Schema(description = "판매자명")
      String sellerName,
      @Schema(description = "상품 이미지")
      String imageURL
) {
   public static ProductGetResponse of (Product product) {
      return new ProductGetResponse (
            product.getDeliveryType().getDelivery(),
            product.getProductName(),
            product.getDiscountRate(),
            product.getPrice(),
            getDiscountedPrice(product.getPrice(), product.getDiscountRate()),
            product.getSeller().getName(),
            product.getImageURL()
      );
   }

   // 원가와 할인율을 받았을 때, 할인된 금액을 세 자리수마다 쉼표를 찍어 반환.
   private static String getDiscountedPrice(Integer originalPrice, Integer discountRate) {
      // 할인된 금액이 정수가 아닌 경우, 반올림을 실행함.
      long discountedPrice = Math.round(originalPrice * (1.0 - discountRate / 100.0));
      return new DecimalFormat("#,###원").format(discountedPrice);
   }
}
