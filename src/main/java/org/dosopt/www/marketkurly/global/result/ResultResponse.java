package org.dosopt.www.marketkurly.global.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultResponse<T> {

   private final HttpStatus status;
   private final String message;
   private T data;

   public static <T> ResultResponse<T> of(ResultCode resultCode, T data) {
      return new ResultResponse<T>(resultCode, data);
   }

   public static ResultResponse of(ResultCode resultCode) {
      return new ResultResponse<>(resultCode);
   }

   public ResultResponse(ResultCode resultCode, T data) {
      this.status = resultCode.getStatus();
      this.message = resultCode.getMessage();
      this.data = data;
   }

   public ResultResponse(ResultCode resultCode) {
      this.status = resultCode.getStatus();
      this.message = resultCode.getMessage();
   }

}