package com.cerouno.qawadis_api.service;

import com.cerouno.qawadis_api.dto.RequestDto;
import com.cerouno.qawadis_api.dto.entityDto.DtMatchDto;
import com.cerouno.qawadis_api.entity.DtMatch;

import java.util.List;

public interface MatchService {

    List<DtMatchDto> getMatchListByStatus (Integer status, boolean init);

    Integer saveMatch (RequestDto<DtMatch> requestDto, Integer userId);
}
