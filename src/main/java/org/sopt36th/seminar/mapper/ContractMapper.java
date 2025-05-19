package org.sopt36th.seminar.mapper;

import org.sopt36th.seminar.common.utils.DateUtil;
import org.sopt36th.seminar.common.utils.RateUtil;
import org.sopt36th.seminar.common.utils.TimeUtil;
import org.sopt36th.seminar.domain.Contract;
import org.sopt36th.seminar.domain.Deposit;
import org.sopt36th.seminar.domain.Saving;
import org.sopt36th.seminar.dto.response.AccountResponse;
import org.sopt36th.seminar.dto.response.GetContractDetailResponse;

import java.util.List;
import java.util.stream.Collectors;

public class ContractMapper {

    public static GetContractDetailResponse toGetContractDetail(Contract contract, Saving saving,
                                                                List<Deposit> deposits, double totalPreferentialRate) {
        String dDay = DateUtil.toFormattedDDay(contract.getStartDate(), contract.getEndDate());

        return new GetContractDetailResponse(
                saving.getName(),
                contract.getAccount(),
                contract.getTotalBalance(),
                TimeUtil.toFormattedTime(contract.getStartDate()),
                TimeUtil.toFormattedTime(contract.getEndDate()),
                dDay,
                RateUtil.toFormattedRate(contract.getTotalPreferentialRate()),
                RateUtil.toFormattedRate(totalPreferentialRate),
                deposits.stream()
                        .map(deposit -> new GetContractDetailResponse.DepositResponse(
                                deposit.getId(),
                                deposit.getCount(),
                                TimeUtil.toFormattedTime(deposit.getDate()),
                                deposit.getPayment(),
                                deposit.getAfterDeposit(),
                                RateUtil.toFormattedRate(deposit.getAppliedRate())
                        ))
                        .collect(Collectors.toList())
        );
    }

    public static AccountResponse toAccountResponse(Contract contract) {
        return new AccountResponse(
                contract.getId(),
                contract.getSaving().getName(),
                contract.getAccount(),
                TimeUtil.toFormattedTime(contract.getStartDate()),
                TimeUtil.toFormattedTime(contract.getEndDate()),
                DateUtil.toFormattedDDay(contract.getStartDate(), contract.getEndDate()),
                contract.getTotalBalance()
        );
    }

    public static List<AccountResponse> toAccountResponseList(List<Contract> contracts) {
        return contracts.stream()
                .map(ContractMapper::toAccountResponse)
                .toList();
    }
}

