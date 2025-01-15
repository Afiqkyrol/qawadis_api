package com.cerouno.qawadis_api.dto;

public class ResponseDto<T> {

    private String message;
    private T data;
    private String detailMessage;

    public ResponseDto(String message, T data, String detailMessage) {
        this.message = message;
        this.data = data;
        this.detailMessage = detailMessage;
    }

    // Getter and Setter methods

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

    public String getDetailMessage() {
        return detailMessage;
    }

    public void setDetailMessage(String detailMessage) {
        this.detailMessage = detailMessage;
    }

    // Static factory methods for consistency

    public static <T> ResponseDto<T> success(String message, T data) {
        return new ResponseDto<>(message, data, null);
    }

    public static <T> ResponseDto<T> success(String message, T data, String detailMessage) {
        return new ResponseDto<>(message, data, detailMessage);
    }

    public static <T> ResponseDto<T> error(String message, String detailMessage) {
        return new ResponseDto<>(message, null, detailMessage);
    }
}
