package org.sopt36th.seminar.controller;

import org.sopt36th.seminar.common.response.ApiResponse;
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

    // TODO 뷰1 - 전체 계좌 목록 조회 => TODO 밑의 줄에 구현 후 완료되면 TODO 삭제하기!


    // TODO 뷰2 - 계좌 상세 정보 조회 (납입 정보 목록까지)
    @GetMapping("/{account-id}")
    public ApiResponse<GetContractDetailResponse> getContractDetail(
            @PathVariable("account-id") Long accountId
    ) {
        GetContractDetailResponse data = contractService.getContractDetail(accountId);

        return ApiResponse.ok(SuccessMessage.GET_CONTRACT_DETAIL_SUCCESS.getMessage(), data);
    }


    // TODO 뷰3 - 계좌 상태 조회
    @GetMapping("/{account-id}/state")
    public ApiResponse<GetContractStateResponse> getContractState(
            @PathVariable("account-id") Long accountId
    ) {
        GetContractStateResponse data = contractService.getContractState(accountId);

        return ApiResponse.ok(SuccessMessage.GET_CONTRACT_STATE_SUCCESS.getMessage(), data);
    }

    // TODO 뷰4 - 계좌 이율 조회

}
