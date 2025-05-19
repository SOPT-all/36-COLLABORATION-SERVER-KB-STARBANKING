package org.sopt36th.seminar.common.exception.custom;

import org.sopt36th.seminar.common.exception.BusinessException;
import org.sopt36th.seminar.common.exception.ErrorCode;

public class ContractNotFoundException extends BusinessException {
    public ContractNotFoundException(ErrorCode errorcode) {
        super(errorcode);
    }
}
