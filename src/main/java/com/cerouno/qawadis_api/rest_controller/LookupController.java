package com.cerouno.qawadis_api.rest_controller;

import com.cerouno.qawadis_api.constants.AppConstants;
import com.cerouno.qawadis_api.dto.LookupDataDto;
import com.cerouno.qawadis_api.dto.RequestDto;
import com.cerouno.qawadis_api.exception.AuthorizationDeniedException;
import com.cerouno.qawadis_api.security.Security;
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

    @GetMapping("/item")
    public ResponseEntity<?> getLookupDataActive(HttpServletRequest request, @RequestParam("table") String table, @RequestParam("init") boolean init){

        if(!Security.AuthorizeToken(request)) throw new AuthorizationDeniedException("Invalid Token");
        LookupDataDto<?> lookupData = lookupService.getLookupDataActive(table, init);
        return ResponseBuilder.success(AppConstants.SUCCESS_MSG, lookupData);

    }

    @PostMapping("/item")
    public ResponseEntity<?> saveLookupData(HttpServletRequest request, @RequestBody RequestDto requestDto, @RequestParam("table") String table){

        if(!Security.AuthorizeToken(request)) throw new AuthorizationDeniedException("Invalid Token");
        return ResponseBuilder.success(AppConstants.SUCCESS_MSG, lookupService.saveLookupData(requestDto, table));

    }
}
