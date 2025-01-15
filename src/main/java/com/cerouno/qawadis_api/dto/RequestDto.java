package com.cerouno.qawadis_api.dto;

public class RequestDto<T> {

    private Integer userId;
    private T body;

    public RequestDto(Integer userId, T body) {
        this.userId = userId;
        this.body = body;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public T getData() {
        return body;
    }

    public void setData(T body) {
        this.body = body;
    }
}
