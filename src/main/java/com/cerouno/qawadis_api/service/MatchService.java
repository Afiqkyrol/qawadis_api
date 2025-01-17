package com.cerouno.qawadis_api.service;

import com.cerouno.qawadis_api.dto.entity_dto.DtMatchDto;

import java.util.List;

public interface MatchService {

    List<DtMatchDto> getMatchListByStatus (Integer status, boolean init);
}
