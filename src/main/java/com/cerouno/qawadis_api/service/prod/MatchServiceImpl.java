package com.cerouno.qawadis_api.service.prod;

import com.cerouno.qawadis_api.dto.RequestDto;
import com.cerouno.qawadis_api.dto.entityDto.DtMatchDto;
import com.cerouno.qawadis_api.dto.entityDto.MtUserMatchDto;
import com.cerouno.qawadis_api.entity.DtMatch;
import com.cerouno.qawadis_api.entity.MtUserMatch;
import com.cerouno.qawadis_api.repository.DtMatchRepository;
import com.cerouno.qawadis_api.repository.DtUserRepository;
import com.cerouno.qawadis_api.repository.MtUserMatchRepository;
import com.cerouno.qawadis_api.service.MatchService;
import com.cerouno.qawadis_api.utility.BusinessHelper;
import com.cerouno.qawadis_api.utility.dtoMapper.DtMatchMapper;
import com.cerouno.qawadis_api.utility.dtoMapper.MtUserMatchMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("prod")
public class MatchServiceImpl implements MatchService {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    DtMatchRepository dtMatchRepository;

    @Autowired
    DtUserRepository dtUserRepository;

    @Autowired
    MtUserMatchRepository mtUserMatchRepository;

    @Autowired
    BusinessHelper businessHelper;

    @Override
    public List<DtMatchDto> getMatchListByStatus(Integer status, boolean init) {
        return DtMatchMapper.toDto(dtMatchRepository.findByStatus_statusId(status), init);
    }

    @Override
    public DtMatch findMatchById(Integer id) {
        return dtMatchRepository.findByMatchId(id);
    }

    @Override
    public List<MtUserMatchDto> getPlayerListByMatch(Integer matchId, Integer status, boolean init) {
        return MtUserMatchMapper.toDto(mtUserMatchRepository.findByGame_matchIdAndStatus_statusId(matchId, status), init);
    }

    @Override
    public Integer saveMatch(RequestDto<DtMatch> requestDto, Integer userId) {
        DtMatch dtMatch = objectMapper.convertValue(requestDto.getBody(), DtMatch.class);

        if(dtMatch.getMatchId() == null){
            dtMatch.setCreatedBy(dtUserRepository.findByUserId(userId));
        }else {
            dtMatch.setMaintainBy(dtUserRepository.findByUserId(userId));
        }
        return dtMatchRepository.save(dtMatch).getMatchId();
    }

    @Override
    public Integer saveUserMatch(RequestDto<MtUserMatch> requestDto, Integer userId) {
        MtUserMatch mtUserMatch =  objectMapper.convertValue(requestDto.getBody(), MtUserMatch.class);
        mtUserMatch.setGame(dtMatchRepository.findByMatchId(mtUserMatch.getGame().getMatchId()));

        businessHelper.validateUserMatchCriteria(mtUserMatch, mtUserMatchRepository, userId);
        if(mtUserMatch.getUserMatchId() == null){
            mtUserMatch.setPlayer(dtUserRepository.findByUserId(userId));
            mtUserMatch.setCreatedBy(dtUserRepository.findByUserId(userId));
        }else{
            mtUserMatch.setMaintainBy(dtUserRepository.findByUserId(userId));
        }
        return mtUserMatchRepository.save(mtUserMatch).getUserMatchId();
    }

}
