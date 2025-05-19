package org.sopt36th.seminar.controller;

import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "뷰1) 전체 계좌 조회", description = "전체 계좌의 합산 금액과 계좌 목록을 조회합니다.")
    @GetMapping
    public ApiResponse<GetAllAccountsResponse> getAllAccounts() {
        return ApiResponse.ok(SuccessMessage.GET_ALL_CONTRACTS_SUCCESS.getMessage(), contractService.getAllAccounts());
    }

    @Operation(summary = "뷰2) 특정 적금 상세 조회", description = "특정 계좌의 상세 내용과 납입 목록 내역을 조회합니다.")
    @GetMapping("/{account-id}")
    public ApiResponse<GetContractDetailResponse> getContractDetail(
            @PathVariable("account-id") Long accountId
    ) {
        GetContractDetailResponse data = contractService.getContractDetail(accountId);

        return ApiResponse.ok(SuccessMessage.GET_CONTRACT_DETAIL_SUCCESS.getMessage(), data);
    }

    @Operation(summary = "뷰3) 특정 적금 계좌 상태 조회", description = "특정 계좌의 마지막 거래 내역과 계좌 상태가 정상인지 조회합니다.")
    @GetMapping("/{account-id}/state")
    public ApiResponse<GetContractStateResponse> getContractState(
            @PathVariable("account-id") Long accountId
    ) {
        GetContractStateResponse data = contractService.getContractState(accountId);

        return ApiResponse.ok(SuccessMessage.GET_CONTRACT_STATE_SUCCESS.getMessage(), data);
    }

    @Operation(summary = "뷰4) 특정 적금 계좌 이율 조회", description = "특정 계좌의 우대 이율 목록을 조회합니다.")
    @GetMapping("/{account-id}/rates")
    public ApiResponse<GetAccountRatesResponse> getAccountRates(@PathVariable("account-id") Long accountId
    ) {
        return ApiResponse.ok(
                SuccessMessage.GET_PREFERENTIAL_RATES_SUCCESS.getMessage(),
                contractService.getAccountRates(accountId)
        );
    }
}
