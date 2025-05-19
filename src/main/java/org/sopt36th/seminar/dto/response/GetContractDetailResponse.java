package org.sopt36th.seminar.dto.response;

import java.util.List;

public record GetContractDetailResponse(
        String savingAccountName,
        String accountNumber,
        Integer totalBalance,
        String startDate,
        String endDate,
        String dDay,
        String preferentialRate,
        String maxAppliedRate,
        List<DepositResponse> deposits
) {
    public record DepositResponse(
            Long id,
            Integer count,
            String depositDate,
            Integer payment,
            Integer afterPaymentBalance,
            String appliedRate
    ) {
    }
}
