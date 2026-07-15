package com.ecoplan.erp.common.response;

public class ApiResponse<T> {

    private final boolean success;

    private final T data;

    private final String message;

    private ApiResponse(
            boolean success,
            T data,
            String message
    ) {
        this.success = success;
        this.data = data;
        this.message = message;
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(true, data, "SUCCESS");
    }

    public static ApiResponse<Void> success() {
        return new ApiResponse<>(true, null, "SUCCESS");
    }

    public static <T> ApiResponse<T> fail(
            T data,
            String message
    ) {
        return new ApiResponse<>(false, data, message);
    }

    public boolean isSuccess() {
        return success;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

}