package com.cerouno.qawadis_api.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.cerouno.qawadis_api.dto.ResponseDto;

public class ResponseBuilder {

    public static <T> ResponseEntity<ResponseDto<T>> success(String message, T data) {
        return ResponseEntity.ok(ResponseDto.success(message, data));
    }

    public static <T> ResponseEntity<ResponseDto<T>> success(String message, T data, String detailMessage) {
        return ResponseEntity.ok(ResponseDto.success(message, data, detailMessage));
    }

    public static <T> ResponseEntity<ResponseDto<T>> error(String message, String detailMessage) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseDto.error(message, detailMessage));
    }

    public static <T> ResponseEntity<ResponseDto<T>> error(HttpStatus status, String message, String detailMessage) {
        return ResponseEntity.status(status).body(ResponseDto.error(message, detailMessage));
    }
}
