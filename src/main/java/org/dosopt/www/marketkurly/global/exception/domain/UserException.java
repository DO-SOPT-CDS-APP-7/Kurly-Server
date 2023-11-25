package org.dosopt.www.marketkurly.global.exception.domain;

import org.dosopt.www.marketkurly.global.error.CustomErrorCode;
import org.dosopt.www.marketkurly.global.exception.BusinessException;

public class UserException extends BusinessException {
    public UserException(CustomErrorCode errorCode) {
        super(errorCode);
    }
}
