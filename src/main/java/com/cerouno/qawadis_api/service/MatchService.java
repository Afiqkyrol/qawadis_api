package com.cerouno.qawadis_api.service;

import com.cerouno.qawadis_api.dto.RequestDto;
import com.cerouno.qawadis_api.dto.entityDto.DtMatchDto;
import com.cerouno.qawadis_api.entity.DtMatch;
import com.cerouno.qawadis_api.entity.MtUserMatch;

import java.util.List;

public interface MatchService {

    List<DtMatchDto> getMatchListByStatus (Integer status, boolean init);

    Integer saveMatch (RequestDto<DtMatch> requestDto, Integer userId);

    DtMatch findMatchById (Integer id);

    Integer saveUserMatch (RequestDto<MtUserMatch> requestDto, Integer userId);
}
