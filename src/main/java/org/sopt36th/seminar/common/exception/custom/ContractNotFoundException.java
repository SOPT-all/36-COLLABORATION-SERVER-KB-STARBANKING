package org.sopt36th.seminar.common.exception.custom;

import org.sopt36th.seminar.common.exception.BusinessException;
import org.sopt36th.seminar.common.exception.GlobalErrorCode;


public class ContractNotFoundException extends BusinessException {
    public ContractNotFoundException(String message) {
        super(GlobalErrorCode.CONTRACT_NOT_FOUND);

    }
}
