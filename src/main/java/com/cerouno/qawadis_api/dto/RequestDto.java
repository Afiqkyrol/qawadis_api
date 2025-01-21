package com.cerouno.qawadis_api.dto;

public class RequestDto<T> {

    private T body;

    public RequestDto(T body) {
        this.body = body;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
