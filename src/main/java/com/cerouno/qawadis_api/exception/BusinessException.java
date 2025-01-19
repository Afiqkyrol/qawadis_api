package com.cerouno.qawadis_api.exception;

import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException{

    private HttpStatus status;

    public BusinessException(HttpStatus status, String message){
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
