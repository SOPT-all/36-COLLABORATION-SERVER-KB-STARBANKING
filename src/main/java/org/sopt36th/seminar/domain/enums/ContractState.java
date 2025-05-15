package org.sopt36th.seminar.domain.enums;


public enum ContractState {
    ACTIVE("정상"),
    INACTIVE("사용 불가");

    private final String state;

    ContractState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
