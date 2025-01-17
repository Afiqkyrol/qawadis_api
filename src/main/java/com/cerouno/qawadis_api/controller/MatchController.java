package com.cerouno.qawadis_api.controller;

import com.cerouno.qawadis_api.constants.AppConstants;
import com.cerouno.qawadis_api.dto.entity_dto.DtMatchDto;
import com.cerouno.qawadis_api.exception.AuthorizationDeniedException;
import com.cerouno.qawadis_api.security.SecurityAuth;
import com.cerouno.qawadis_api.service.MatchService;
import com.cerouno.qawadis_api.utility.ResponseBuilder;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/match")
public class MatchController {

    private final MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("/open")
    public ResponseEntity<?> getMatchListActive (HttpServletRequest request, @RequestParam("init") boolean init){
        if(!SecurityAuth.AuthorizeToken(request)) throw new AuthorizationDeniedException("Invalid token");
        return ResponseBuilder.success(AppConstants.SUCCESS_MSG, matchService.getMatchListByStatus(AppConstants.GSTS_ACTIVE, init));
    }
}
