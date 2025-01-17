package com.cerouno.qawadis_api.controller;

import com.cerouno.qawadis_api.constants.AppConstants;
import com.cerouno.qawadis_api.dto.LoginDto;
import com.cerouno.qawadis_api.dto.RequestDto;
import com.cerouno.qawadis_api.entity.DtUser;
import com.cerouno.qawadis_api.exception.AuthorizationDeniedException;
import com.cerouno.qawadis_api.service.AuthService;
import com.cerouno.qawadis_api.utility.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody RequestDto<LoginDto> request) {
        try {
            String token = authService.login(request);
            return ResponseBuilder.success(AppConstants.SUCCESS_MSG, token);
        }catch (AuthorizationDeniedException e){
            throw e;
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RequestDto<DtUser> request) {
        try {
            String token = authService.register(request);
            return ResponseBuilder.success(AppConstants.SUCCESS_MSG, token);
        }catch (AuthorizationDeniedException e){
            throw e;
        }
    }
}
