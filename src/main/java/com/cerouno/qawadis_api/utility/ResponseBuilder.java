package com.cerouno.qawadis_api.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.cerouno.qawadis_api.dto.ResponseDTO;

public class ResponseBuilder {

    public static <T> ResponseEntity<ResponseDTO<T>> success(String message, T data) {
        return ResponseEntity.ok(ResponseDTO.success(message, data));
    }

    public static <T> ResponseEntity<ResponseDTO<T>> success(String message, T data, String detailMessage) {
        return ResponseEntity.ok(ResponseDTO.success(message, data, detailMessage));
    }

    public static <T> ResponseEntity<ResponseDTO<T>> error(String message, String detailMessage) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseDTO.error(message, detailMessage));
    }
}
