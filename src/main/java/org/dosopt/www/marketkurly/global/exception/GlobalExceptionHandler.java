package org.dosopt.www.marketkurly.global.exception;

import org.dosopt.www.marketkurly.global.error.CommonErrorCode;
import org.dosopt.www.marketkurly.global.error.CustomErrorCode;
import org.dosopt.www.marketkurly.global.error.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.security.InvalidParameterException;


@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
   @ExceptionHandler(BusinessException.class)
   public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException e) {
      CustomErrorCode errorCode = e.getErrorCode();
      return new ResponseEntity<>(ErrorResponse.of(errorCode), errorCode.getStatus());
   }

   @ExceptionHandler({ IllegalArgumentException.class, InvalidParameterException.class })
   public ResponseEntity<ErrorResponse> handleParameterException(Exception e) {
      return new ResponseEntity<>(
            ErrorResponse.of(CommonErrorCode.INVALID_PARAMETER),
            CommonErrorCode.INVALID_PARAMETER.getStatus());
   }


   // 404 에러 핸들링
   @Override
   protected ResponseEntity<Object> handleNoHandlerFoundException(
         NoHandlerFoundException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

      return new ResponseEntity<>(
            ErrorResponse.of(CommonErrorCode.RESOURCE_NOT_FOUND),
            CommonErrorCode.RESOURCE_NOT_FOUND.getStatus());
   }

   @ExceptionHandler(Exception.class)
   public ResponseEntity<ErrorResponse> handleGlobalException(Exception e) {
      return new ResponseEntity<>(
            ErrorResponse.of(CommonErrorCode.INTERNAL_SERVER_ERROR),
            CommonErrorCode.INTERNAL_SERVER_ERROR.getStatus());
      }
}
