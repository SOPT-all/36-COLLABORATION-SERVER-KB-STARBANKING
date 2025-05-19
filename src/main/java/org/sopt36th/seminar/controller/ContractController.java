package org.sopt36th.seminar.controller;

import org.sopt36th.seminar.common.response.ApiResponse;
import org.sopt36th.seminar.dto.response.GetAccountRatesResponse;
import org.sopt36th.seminar.dto.response.GetAllAccountsResponse;
import org.sopt36th.seminar.common.response.message.SuccessMessage;
import org.sopt36th.seminar.dto.response.GetContractDetailResponse;
import org.sopt36th.seminar.dto.response.GetContractStateResponse;
import org.sopt36th.seminar.service.ContractService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/accounts")
public class ContractController {

    private final ContractService contractService;

    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping
    public ApiResponse<GetAllAccountsResponse> getAllAccounts() {
        return ApiResponse.ok(SuccessMessage.GET_ALL_CONTRACTS_SUCCESS.getMessage(), contractService.getAllAccounts());
    }

    @GetMapping("/{account-id}")
    public ApiResponse<GetContractDetailResponse> getContractDetail(
            @PathVariable("account-id") Long accountId
    ) {
        GetContractDetailResponse data = contractService.getContractDetail(accountId);

        return ApiResponse.ok(SuccessMessage.GET_CONTRACT_DETAIL_SUCCESS.getMessage(), data);
    }

    @GetMapping("/{account-id}/state")
    public ApiResponse<GetContractStateResponse> getContractState(
            @PathVariable("account-id") Long accountId
    ) {
        GetContractStateResponse data = contractService.getContractState(accountId);

        return ApiResponse.ok(SuccessMessage.GET_CONTRACT_STATE_SUCCESS.getMessage(), data);
    }

    @GetMapping("/{account-id}/rates")
    public ApiResponse<GetAccountRatesResponse> getAccountRates(@PathVariable("account-id") Long accountId
    ) {
        return ApiResponse.ok(
                SuccessMessage.GET_PREFERENTIAL_RATES_SUCCESS.getMessage(),
                contractService.getAccountRates(accountId)
        );
    }
}
