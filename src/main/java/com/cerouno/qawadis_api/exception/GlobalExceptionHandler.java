package com.cerouno.qawadis_api.exception;

import com.cerouno.qawadis_api.constants.AppConstants;
import com.cerouno.qawadis_api.utility.ResponseBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e) {
        return ResponseBuilder.error(AppConstants.ERROR_MSG, e.getCause().getMessage());
    }

}
