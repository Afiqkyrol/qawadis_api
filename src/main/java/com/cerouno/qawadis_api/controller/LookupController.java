package com.cerouno.qawadis_api.controller;

import com.cerouno.qawadis_api.constant.AppConstants;
import com.cerouno.qawadis_api.dto.RequestDto;
import com.cerouno.qawadis_api.exception.AuthorizationDeniedException;
import com.cerouno.qawadis_api.security.SecurityAuth;
import com.cerouno.qawadis_api.service.LookupService;
import com.cerouno.qawadis_api.utility.ResponseBuilder;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lookups")
public class LookupController {

    private final LookupService lookupService;

    @Autowired
    public LookupController(LookupService lookupService) {
        this.lookupService = lookupService;
    }

    @GetMapping("/getLookupData")
    public ResponseEntity<?> getLookupData(HttpServletRequest request, @RequestParam("table") String table, @RequestParam(value = "active", required = false) Boolean active, @RequestParam("init") boolean init){
        if(!SecurityAuth.AuthorizeToken(request)) throw new AuthorizationDeniedException(AppConstants.INVALID_TOKEN_MSG);
        return ResponseBuilder.success(AppConstants.SUCCESS_MSG, lookupService.getLookupData(table, active, init));
    }

    @PostMapping("/saveLookupData")
    public ResponseEntity<?> saveLookupData(HttpServletRequest request, @RequestBody RequestDto<?> requestDto, @RequestParam("table") String table){

        if(!SecurityAuth.AuthorizeToken(request)) throw new AuthorizationDeniedException(AppConstants.INVALID_TOKEN_MSG);
        return ResponseBuilder.success(AppConstants.SUCCESS_MSG, lookupService.saveLookupData(requestDto, table, SecurityAuth.ExtractUserId(request)));

    }
}
