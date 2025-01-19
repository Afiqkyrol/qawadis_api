package com.cerouno.qawadis_api.service.dev;

import com.cerouno.qawadis_api.dto.RequestDto;
import com.cerouno.qawadis_api.dto.entityDto.DtMatchDto;
import com.cerouno.qawadis_api.entity.DtMatch;
import com.cerouno.qawadis_api.repository.DtMatchRepository;
import com.cerouno.qawadis_api.repository.DtUserRepository;
import com.cerouno.qawadis_api.repository.MtUserMatchRepository;
import com.cerouno.qawadis_api.service.MatchService;
import com.cerouno.qawadis_api.utility.dtoMapper.DtMatchMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    DtMatchRepository dtMatchRepository;

    @Autowired
    DtUserRepository dtUserRepository;

    @Autowired
    MtUserMatchRepository mtUserMatchRepository;

    @Override
    public List<DtMatchDto> getMatchListByStatus(Integer status, boolean init) {
        return DtMatchMapper.toDto(dtMatchRepository.findByStatus_statusId(status), init);
    }

    @Override
    public Integer saveMatch(RequestDto<DtMatch> requestDto, Integer userId) {
        DtMatch dtMatch = objectMapper.convertValue(requestDto.getBody(), DtMatch.class);

        if(dtMatch.getMatchId() == null){
            dtMatch.setCreatedBy(userId, dtUserRepository);
        }else {
            dtMatch.setMaintainBy(userId, dtUserRepository);
        }
        return dtMatchRepository.save(dtMatch).getMatchId();
    }

}
