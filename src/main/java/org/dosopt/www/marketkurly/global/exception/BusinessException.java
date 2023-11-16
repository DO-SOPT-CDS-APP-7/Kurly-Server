package org.dosopt.www.marketkurly.global.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.dosopt.www.marketkurly.global.error.CustomErrorCode;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BusinessException extends RuntimeException {
   private CustomErrorCode errorCode;
   public BusinessException(String message, CustomErrorCode errorCode) {
      super(message);
      this.errorCode = errorCode;
   }

   public BusinessException(CustomErrorCode errorCode) {
      this.errorCode = errorCode;
   }
}
