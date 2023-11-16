package org.dosopt.www.marketkurly.global.result;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public enum ResultCode {
   HEALTH_CHECK_SUCCESS(HttpStatus.OK, "🫀Health Check 성공🫁"),

   // PRODUCT 관련
   GET_PRODUCT_SUCCESS(HttpStatus.OK, "상품 조회 성공"),
   ;

   private final HttpStatus status;
   private final String message;
}