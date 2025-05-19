package org.sopt36th.seminar.dto.response;

public record AccountResponse(
        Long id,
        String name,
        String accountNumber,
        String startDate,
        String endDate,
        String dDay,
        int accountBalance
) {
}
