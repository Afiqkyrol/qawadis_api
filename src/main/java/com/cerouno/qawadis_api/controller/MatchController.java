package com.cerouno.qawadis_api.controller;

import com.cerouno.qawadis_api.constant.AppConstants;
import com.cerouno.qawadis_api.dto.RequestDto;
import com.cerouno.qawadis_api.entity.DtMatch;
import com.cerouno.qawadis_api.entity.MtUserMatch;
import com.cerouno.qawadis_api.exception.AuthorizationDeniedException;
import com.cerouno.qawadis_api.security.SecurityAuth;
import com.cerouno.qawadis_api.service.MatchService;
import com.cerouno.qawadis_api.utility.ResponseBuilder;
import com.cerouno.qawadis_api.utility.dtoMapper.DtMatchMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;

@RestController
@RequestMapping("/match")
public class MatchController {

    private final MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @PostMapping("/saveMatch")
    public ResponseEntity<?> saveMatch(HttpServletRequest request, @RequestBody RequestDto<DtMatch> requestDto) {
        if(!SecurityAuth.AuthorizeToken(request)) throw new AuthorizationDeniedException(AppConstants.INVALID_TOKEN_MSG);
        return ResponseBuilder.success(AppConstants.SUCCESS_MSG, matchService.saveMatch(requestDto, SecurityAuth.ExtractUserId(request)));
    }

    @GetMapping("/getMatchList")
    public ResponseEntity<?> getMatchList(HttpServletRequest request,
                                          @RequestParam(value = "sportId", required = false) Long sportId,
                                          @RequestParam(value = "venue", required = false) String venue,
                                          @RequestParam(value = "date", required = false) LocalDate date,
                                          @RequestParam(value = "time", required = false) LocalTime time,
                                          @RequestParam(value = "statusId", required = false) Long statusId,
                                          @RequestParam(value = "createdById", required = false) Long createdById,
                                          @RequestParam("init") boolean init) {
        if (!SecurityAuth.AuthorizeToken(request)) throw new AuthorizationDeniedException(AppConstants.INVALID_TOKEN_MSG);
        return ResponseBuilder.success(AppConstants.SUCCESS_MSG, matchService.getMatchList(sportId, venue, date, time, statusId, createdById, init));
    }

    @GetMapping("/getMatchListByStatus")
    public ResponseEntity<?> getMatchListByStatus(HttpServletRequest request, @RequestParam("status") Long status, @RequestParam("init") boolean init) {
        if (!SecurityAuth.AuthorizeToken(request)) throw new AuthorizationDeniedException(AppConstants.INVALID_TOKEN_MSG);
        return ResponseBuilder.success(AppConstants.SUCCESS_MSG, matchService.getMatchListByStatus(status, init));
    }

    @GetMapping("/getPlayerListByMatchId")
    public ResponseEntity<?> getPlayerListByMatch(HttpServletRequest request, @RequestParam("matchId") Long matchId, @RequestParam(value = "status", required = false) Long status, @RequestParam("init") boolean init) {
        if (!SecurityAuth.AuthorizeToken(request)) throw new AuthorizationDeniedException(AppConstants.INVALID_TOKEN_MSG);
        return ResponseBuilder.success(AppConstants.SUCCESS_MSG, matchService.getPlayerListByMatch(matchId, status, init));
    }

    @GetMapping("/findMatchById")
    public ResponseEntity<?> findMatchById(HttpServletRequest request, @RequestParam("matchId") Long matchId, @RequestParam("init") boolean init){
        if (!SecurityAuth.AuthorizeToken(request)) throw new AuthorizationDeniedException(AppConstants.INVALID_TOKEN_MSG);
        return ResponseBuilder.success(AppConstants.SUCCESS_MSG, matchService.findMatchById(matchId, init));
    }

    @PostMapping("/saveUserMatch")
    public ResponseEntity<?> saveUserMatch(HttpServletRequest request, @RequestBody RequestDto<MtUserMatch> requestDto){
        if (!SecurityAuth.AuthorizeToken(request)) throw new AuthorizationDeniedException(AppConstants.INVALID_TOKEN_MSG);
        return ResponseBuilder.success(AppConstants.SUCCESS_MSG, matchService.saveUserMatch(requestDto, SecurityAuth.ExtractUserId(request)));
    }

}