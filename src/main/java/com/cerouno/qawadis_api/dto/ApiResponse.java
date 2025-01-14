package com.cerouno.qawadis_api.dto;

import org.springframework.http.HttpStatus;

import java.util.List;

public class ApiResponse<T> {

    private boolean success;
    private int statusCode;
    private String message;
    private T data;
    private String errorMessage;

    public ApiResponse(boolean success, int statusCode, String message, T data, String errorMessage) {
        this.success = success;
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
        this.errorMessage = errorMessage;
    }

    // Getter and Setter methods

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    // Static factory methods for easier creation of responses

    public static <T> ApiResponse<T> success(T data, String message) {
        return new ApiResponse<>(true, HttpStatus.OK.value(), message, data, null);
    }

    public static <T> ApiResponse<T> notFound(String message) {
        return new ApiResponse<>(false, HttpStatus.NOT_FOUND.value(), message, null, null);
    }

    public static <T> ApiResponse<T> internalServerError(String message, String errorMessage) {
        return new ApiResponse<>(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), message, null, errorMessage);
    }

}
