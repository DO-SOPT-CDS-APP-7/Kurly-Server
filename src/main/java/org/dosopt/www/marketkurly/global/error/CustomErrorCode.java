package org.dosopt.www.marketkurly.global.error;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public enum CustomErrorCode {
   // PRODUCT
   PRODUCT_NOT_FOUND(HttpStatus.BAD_REQUEST, "존재하지 않는 상품입니다."),

   // USER
   USER_NOT_FOUND(HttpStatus.BAD_REQUEST, "존재하지 않는 유저입니다."),

   // CART
   CART_NOT_FOUND(HttpStatus.BAD_REQUEST, "장바구니가 존재하지 않습니다."),
   CARTITEM_NOT_FOUND(HttpStatus.BAD_REQUEST, "장바구니에 담긴 상품이 존재하지 않습니다.");

   private final HttpStatus status;
   private final String message;
}
