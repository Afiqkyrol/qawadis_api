package com.cerouno.qawadis_api.service;

import com.cerouno.qawadis_api.dto.RequestDto;
import com.cerouno.qawadis_api.dto.entityDto.DtMatchDto;
import com.cerouno.qawadis_api.dto.entityDto.MtUserMatchDto;
import com.cerouno.qawadis_api.entity.DtMatch;
import com.cerouno.qawadis_api.entity.MtUserMatch;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface MatchService {

    List<DtMatchDto> getMatchList(Long sportId, String venue, LocalDate date, LocalTime time, Long statusId, Long createdById, boolean init);

    List<DtMatchDto> getMatchListByStatus (Long status, boolean init);

    Long saveMatch (RequestDto<DtMatch> requestDto, Long userId);

    DtMatchDto findMatchById (Long id, boolean init);

    Long saveUserMatch (RequestDto<MtUserMatch> requestDto, Long userId);

    List<MtUserMatchDto> getPlayerListByMatch(Long matchId, Long status, boolean init);
}
