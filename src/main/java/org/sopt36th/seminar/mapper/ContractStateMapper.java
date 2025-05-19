package org.sopt36th.seminar.mapper;

import org.sopt36th.seminar.common.utils.TimeUtil;
import org.sopt36th.seminar.domain.Contract;
import org.sopt36th.seminar.domain.Deposit;
import org.sopt36th.seminar.dto.response.GetContractStateResponse;

public class ContractStateMapper {

    public static GetContractStateResponse toGetContractState(Contract contract, Deposit deposit) {

        return new GetContractStateResponse(
                deposit.getCount(),
                contract.getState().getState(),
                TimeUtil.toFormattedTime(deposit.getDate()),
                TimeUtil.calculateMonth(contract.getStartDate(), contract.getEndDate())
        );
    }
}

