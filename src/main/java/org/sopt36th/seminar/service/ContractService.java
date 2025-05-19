package org.sopt36th.seminar.service;

import lombok.RequiredArgsConstructor;
import org.sopt36th.seminar.common.exception.custom.ContractNotFoundException;
import org.sopt36th.seminar.domain.Contract;
import org.sopt36th.seminar.domain.Deposit;
import org.sopt36th.seminar.domain.Saving;
import org.sopt36th.seminar.dto.response.GetContractDetailResponse;
import org.sopt36th.seminar.mapper.ContractMapper;
import org.sopt36th.seminar.repository.ContractRepository;
import org.sopt36th.seminar.repository.DepositRepository;
import org.sopt36th.seminar.repository.PreferentialRateRepository;
import org.sopt36th.seminar.repository.SavingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.sopt36th.seminar.common.exception.GlobalErrorCode.CONTRACT_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class ContractService {
    private final PreferentialRateRepository preferentialRateRepository;
    private final ContractRepository contractRepository;
    private final SavingRepository savingRepository;
    private final DepositRepository depositRepository;

    // 효은
    public GetContractDetailResponse getContractDetail(Long savingId) {

        Contract contract = contractRepository.findBySavingId(savingId)
                .orElseThrow(() -> new ContractNotFoundException(CONTRACT_NOT_FOUND.getMessage()));
        Saving saving = savingRepository.findById(contract.getSaving().getId())
                .orElseThrow(() -> new ContractNotFoundException(CONTRACT_NOT_FOUND.getMessage()));

        double totalPreferentialRate = preferentialRateRepository.sumAllRates(saving.getId());
        List<Deposit> deposits = depositRepository.findByContractId(contract.getId());

        return ContractMapper.toGetContractDetail(contract, saving, deposits, totalPreferentialRate);
    }

    // 소연

}
