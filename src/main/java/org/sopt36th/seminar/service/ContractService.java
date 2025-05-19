package org.sopt36th.seminar.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.sopt36th.seminar.domain.Contract;
import org.sopt36th.seminar.dto.response.AccountResponse;
import org.sopt36th.seminar.dto.response.GetAllAccountsResponse;
import org.sopt36th.seminar.repository.ContractRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContractService {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd");


    private final ContractRepository contractRepository;

    // 효은


    // 소연
    public GetAllAccountsResponse getAllAccounts() {
        List<Contract> contracts = contractRepository.findAll();

        int totalAccountBalance = contracts.stream()
                .mapToInt(Contract::getTotalBalance)
                .sum();
        List<AccountResponse> accountResponses = contracts.stream()
                .map(contract -> new AccountResponse(
                        contract.getId(),
                        contract.getSaving().getName(),
                        contract.getAccount(),
                        formatDate(contract.getStartDate()),
                        formatDate(contract.getEndDate()),
                        calculateDDay(contract.getEndDate()),
                        contract.getTotalBalance()
                ))
                .toList();

        return new GetAllAccountsResponse(totalAccountBalance, accountResponses);
    }

    private String formatDate(LocalDate date) {
        return date.format(FORMATTER);
    }

    private String calculateDDay(LocalDate endDate) {
        LocalDate today = LocalDate.now();
        long days = java.time.temporal.ChronoUnit.DAYS.between(today, endDate);

        return days > 0 ? "D-" + days : "만료됨";
    }
}
