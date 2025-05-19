package org.sopt36th.seminar.common.response.message;

import lombok.Getter;

@Getter
public enum SuccessMessage {

    GET_ALL_CONTRACTS_SUCCESS("전체 계좌 조회에 성공했습니다."),
    GET_CONTRACT_DETAIL_SUCCESS("거래 내역 조회에 성공했습니다."),
    GET_CONTRACT_STATE_SUCCESS("계좌 상태 조회에 성공했습니다."),
    GET_PREFERENTIAL_RATES_SUCCESS("계좌 이율 조회에 성공했습니다.");

    private final String message;

    SuccessMessage(String message) {
        this.message = message;
    }
}
