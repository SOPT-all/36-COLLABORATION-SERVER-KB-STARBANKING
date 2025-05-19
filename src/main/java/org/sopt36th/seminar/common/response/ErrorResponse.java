package org.sopt36th.seminar.common.response;

import lombok.Getter;
import org.sopt36th.seminar.common.exception.ErrorCode;

@Getter
public class ErrorResponse {

    private final int status;
    private final String message;

    public ErrorResponse(ErrorCode errorCode) {
        this.status = errorCode.getStatus().value();
        this.message = errorCode.getMessage();
    }
}
