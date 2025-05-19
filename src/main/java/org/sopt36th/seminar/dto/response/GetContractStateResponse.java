package org.sopt36th.seminar.dto.response;

public record GetContractStateResponse(Integer depositCount, String accountState, String lastTransaction,
                                       Integer contractPeriod) {
}
