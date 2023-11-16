package org.dosopt.www.marketkurly.global.exception.domain;

import org.dosopt.www.marketkurly.global.error.CustomErrorCode;
import org.dosopt.www.marketkurly.global.exception.BusinessException;

public class ProductException extends BusinessException {
   public ProductException(CustomErrorCode errorCode) {
      super(errorCode);
   }
}
