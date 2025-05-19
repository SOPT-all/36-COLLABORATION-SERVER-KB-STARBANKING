package org.sopt36th.seminar.dto.response;

import java.util.List;

public record GetAllAccountsResponse(int totalAccountBalance, List<AccountResponse> accounts) {
}
