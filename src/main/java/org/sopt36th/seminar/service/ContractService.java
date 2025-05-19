package org.sopt36th.seminar.service;

import lombok.RequiredArgsConstructor;
import org.sopt36th.seminar.common.exception.custom.ContractNotFoundException;
import org.sopt36th.seminar.domain.Contract;
import org.sopt36th.seminar.domain.Deposit;
import org.sopt36th.seminar.domain.Saving;
import org.sopt36th.seminar.dto.response.GetContractDetailResponse;
import org.sopt36th.seminar.dto.response.GetContractStateResponse;
import org.sopt36th.seminar.mapper.ContractMapper;
import org.sopt36th.seminar.mapper.ContractStateMapper;
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
    public GetContractDetailResponse getContractDetail(Long contractId) {

        Contract contract = contractRepository.findById(contractId)
                .orElseThrow(() -> new ContractNotFoundException(CONTRACT_NOT_FOUND.getMessage()));
        Saving saving = contract.getSaving();

        double totalPreferentialRate = preferentialRateRepository.sumAllRates(saving.getId());
        List<Deposit> deposits = depositRepository.findByContractId(contract.getId());

        return ContractMapper.toGetContractDetail(contract, saving, deposits, totalPreferentialRate);
    }

    public GetContractStateResponse getContractState(Long contractId) {
        Contract contract = contractRepository.findById(contractId)
                .orElseThrow(() -> new ContractNotFoundException(CONTRACT_NOT_FOUND.getMessage()));
        Deposit deposit = depositRepository.findTopByContractIdOrderByCreatedAtDesc(contractId);

        return ContractStateMapper.toGetContractState(contract, deposit);

    }

    // 소연

}
