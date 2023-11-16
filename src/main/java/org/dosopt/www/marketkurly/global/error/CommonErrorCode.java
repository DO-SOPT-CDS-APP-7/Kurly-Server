package org.dosopt.www.marketkurly.global.error;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public enum CommonErrorCode {

   INVALID_PARAMETER(HttpStatus.BAD_REQUEST, "올바르지 않은 파라미터입니다."),
   RESOURCE_NOT_FOUND(HttpStatus.NOT_FOUND, "요청한 리소스를 찾을 수 없습니다."),
   INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR , "서버 내부 오류"),

   ;

   private final HttpStatus status;
   private final String message;
}
