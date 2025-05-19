package org.sopt36th.seminar.domain.enums;


import lombok.Getter;

@Getter
public enum ContractState {
    ACTIVE("정상"),
    INACTIVE("사용 불가");

    private final String state;

    ContractState(String state) {
        this.state = state;
    }
}
