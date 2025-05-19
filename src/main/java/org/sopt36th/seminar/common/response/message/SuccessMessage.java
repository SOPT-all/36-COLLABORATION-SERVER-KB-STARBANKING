package org.sopt36th.seminar.common.response.message;

public enum SuccessMessage {

    GET_CONTRACT_DETAIL_SUCCESS(" 거래 내역 조회에 성공했습니다.");

    private final String message;

    SuccessMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
