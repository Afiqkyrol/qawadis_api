package com.cerouno.qawadis_api.exception;

import com.cerouno.qawadis_api.constant.AppConstants;
import com.cerouno.qawadis_api.utility.ResponseBuilder;
import org.apache.tomcat.websocket.AuthenticationException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {

    // General Exception Handler
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e) {
        return ResponseBuilder.error(HttpStatus.INTERNAL_SERVER_ERROR, AppConstants.ERROR_MSG, e.getMessage());
    }

    // BusinessException Handler
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<?> handleBusinessException(BusinessException e) {
        return ResponseBuilder.error(e.getStatus(), AppConstants.ERROR_MSG, e.getMessage());
    }

    // RuntimeException Handler
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRuntimeException(RuntimeException e) {
        return ResponseBuilder.error(HttpStatus.INTERNAL_SERVER_ERROR, AppConstants.ERROR_MSG, e.getMessage());
    }

    // InvalidTokenException Handler
    @ExceptionHandler(AuthorizationDeniedException.class)
    public ResponseEntity<?> handleInvalidTokenException(AuthorizationDeniedException e) {
        return ResponseBuilder.error(HttpStatus.UNAUTHORIZED, AppConstants.ERROR_MSG, e.getMessage());
    }

    // AuthenticationException Handler
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<?> handleAuthenticationException(AuthenticationException e) {
        return ResponseBuilder.error(HttpStatus.UNAUTHORIZED, AppConstants.ERROR_MSG, e.getMessage());
    }

    // BadCredentialsException Handler (Invalid credentials)
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<?> handleBadCredentialsException(BadCredentialsException e) {
        return ResponseBuilder.error(HttpStatus.UNAUTHORIZED, AppConstants.ERROR_MSG, e.getMessage());
    }

    // AccessDeniedException Handler (Access denied due to insufficient permissions)
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<?> handleAccessDeniedException(AccessDeniedException e) {
        return ResponseBuilder.error(HttpStatus.FORBIDDEN, AppConstants.ERROR_MSG, e.getMessage());
    }

    // ConstraintViolationException Handler (For validation constraint violations)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handleConstraintViolationException(ConstraintViolationException e) {
        return ResponseBuilder.error(HttpStatus.BAD_REQUEST, AppConstants.ERROR_MSG, e.getMessage());
    }

    // MethodArgumentTypeMismatchException Handler (For mismatched method argument types)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        return ResponseBuilder.error(HttpStatus.BAD_REQUEST, AppConstants.ERROR_MSG, e.getMessage());
    }

    // MissingServletRequestParameterException Handler (For missing required parameters in the request)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<?> handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        return ResponseBuilder.error(HttpStatus.BAD_REQUEST, AppConstants.ERROR_MSG, e.getMessage());
    }

    // HttpMessageNotReadableException Handler (For malformed JSON or invalid message format)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return ResponseBuilder.error(HttpStatus.BAD_REQUEST, AppConstants.ERROR_MSG, e.getMessage());
    }

    // DataIntegrityViolationException Handler (For database constraint violations, such as unique constraint failures)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        String detailMessage = e.getMessage();
        Throwable rootCause = e.getRootCause(); // This digs deeper than getCause()

        if (rootCause != null && rootCause.getMessage() != null) {
            String causeMessage = rootCause.getMessage();

            if (causeMessage.contains("FOREIGN KEY")) {
                String column = null;

                java.util.regex.Matcher colMatcher = java.util.regex.Pattern
                        .compile("FOREIGN KEY \\(`(.*?)`\\)")
                        .matcher(causeMessage);
                if (colMatcher.find()) {
                    column = colMatcher.group(1);
                }

                if (column != null) {
                    detailMessage = String.format(
                            "Invalid value for '%s'. It must be a reference to an existing record.",
                            column
                    );
                } else {
                    detailMessage = "Invalid operation: A referenced record does not exist or has been deleted.";
                }
            }
        }

        return ResponseBuilder.error(HttpStatus.CONFLICT, AppConstants.ERROR_MSG, detailMessage);
    }

    // BindException Handler (For validation errors during data binding, like form binding issues)
    @ExceptionHandler(BindException.class)
    public ResponseEntity<?> handleBindException(BindException e) {
        return ResponseBuilder.error(HttpStatus.BAD_REQUEST, AppConstants.ERROR_MSG, e.getMessage());
    }

}
