package org.dosopt.www.marketkurly.global.exception.domain;

import org.dosopt.www.marketkurly.global.error.CustomErrorCode;
import org.dosopt.www.marketkurly.global.exception.BusinessException;

public class CartException extends BusinessException {
    public CartException(CustomErrorCode errorCode){
        super(errorCode);
    }
}
