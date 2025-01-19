package com.cerouno.qawadis_api.controller;

import com.cerouno.qawadis_api.constants.AppConstants;
import com.cerouno.qawadis_api.dto.RequestDto;
import com.cerouno.qawadis_api.entity.DtMatch;
import com.cerouno.qawadis_api.exception.AuthorizationDeniedException;
import com.cerouno.qawadis_api.security.SecurityAuth;
import com.cerouno.qawadis_api.service.MatchService;
import com.cerouno.qawadis_api.utility.ResponseBuilder;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/match")
public class MatchController {

    private final MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveMatch(HttpServletRequest request, @RequestBody RequestDto<DtMatch> requestDto) {
        if(!SecurityAuth.AuthorizeToken(request)) throw new AuthorizationDeniedException(AppConstants.INVALID_TOKEN_MSG);
        return ResponseBuilder.success(AppConstants.SUCCESS_MSG, matchService.saveMatch(requestDto, SecurityAuth.ExtractUserId(request)));
    }

    @GetMapping("/open")
    public ResponseEntity<?> getMatchListActive(HttpServletRequest request, @RequestParam("init") boolean init) {
        if (!SecurityAuth.AuthorizeToken(request)) throw new AuthorizationDeniedException(AppConstants.INVALID_TOKEN_MSG);
        return ResponseBuilder.success(AppConstants.SUCCESS_MSG, matchService.getMatchListByStatus(AppConstants.GSTS_ACTIVE, init));
    }

    @GetMapping("/close")
    public ResponseEntity<?> getMatchListInactive(HttpServletRequest request, @RequestParam("init") boolean init) {
        if (!SecurityAuth.AuthorizeToken(request)) throw new AuthorizationDeniedException(AppConstants.INVALID_TOKEN_MSG);
        return ResponseBuilder.success(AppConstants.SUCCESS_MSG, matchService.getMatchListByStatus(AppConstants.GSTS_INACTIVE, init));
    }

    @GetMapping("/cancel")
    public ResponseEntity<?> getMatchListCancel(HttpServletRequest request, @RequestParam("init") boolean init) {
        if (!SecurityAuth.AuthorizeToken(request)) throw new AuthorizationDeniedException(AppConstants.INVALID_TOKEN_MSG);
        return ResponseBuilder.success(AppConstants.SUCCESS_MSG, matchService.getMatchListByStatus(AppConstants.GSTS_CANCEL, init));
    }

}