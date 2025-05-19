package org.sopt36th.seminar.common.response;

import lombok.Getter;

@Getter
public class ApiResponse<T> {

    private final int status;
    private final String message;
    private final T data;

    private ApiResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <T> ApiResponse<T> ok(String message, T data) {
        return new ApiResponse<>(200, message, data);
    }
}
