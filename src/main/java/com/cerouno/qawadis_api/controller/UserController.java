package com.cerouno.qawadis_api.controller;

import com.cerouno.qawadis_api.constants.AppConstants;
import com.cerouno.qawadis_api.exception.AuthorizationDeniedException;
import com.cerouno.qawadis_api.security.SecurityAuth;
import com.cerouno.qawadis_api.service.UserService;
import com.cerouno.qawadis_api.utility.ResponseBuilder;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public ResponseEntity<?> getUser (HttpServletRequest request){
        if(!SecurityAuth.AuthorizeToken(request)) throw new AuthorizationDeniedException(AppConstants.INVALID_TOKEN_MSG);
        return ResponseBuilder.success(AppConstants.SUCCESS_MSG, userService.findUserById(SecurityAuth.ExtractUserId(request)));
    }
}
