package org.sopt36th.seminar.dto.response;

import java.util.List;

public record GetAccountRatesResponse(
        String savingAccountName,
        String accountNumber,
        int contractPeriod,
        String startDate,
        String endDate,
        String baseRate,
        String baseEndDate,
        List<PreferentialRateResponse> preferentialRates
) {
}
