package org.dosopt.www.marketkurly.global.error;

import org.springframework.http.HttpStatus;

public record ErrorResponse (
   HttpStatus status,
   String message
) {

   public static ErrorResponse of (CustomErrorCode errorCode) {
      return new ErrorResponse(
            errorCode.getStatus(),
            errorCode.getMessage()
      );
   }

   public static ErrorResponse of (CommonErrorCode errorCode) {
      return new ErrorResponse(
            errorCode.getStatus(),
            errorCode.getMessage()
      );
   }

}
