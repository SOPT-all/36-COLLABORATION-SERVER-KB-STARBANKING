package org.sopt36th.seminar.dto.response;

public record PreferentialRateResponse(
        Long id,
        String name,
        String rate,
        String startDate,
        String endDate
) {
}
