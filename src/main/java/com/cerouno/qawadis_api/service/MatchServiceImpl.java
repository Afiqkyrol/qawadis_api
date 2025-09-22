package com.cerouno.qawadis_api.service;

import com.cerouno.qawadis_api.dto.RequestDto;
import com.cerouno.qawadis_api.dto.entityDto.DtMatchDto;
import com.cerouno.qawadis_api.dto.entityDto.MtUserMatchDto;
import com.cerouno.qawadis_api.entity.*;
import com.cerouno.qawadis_api.repository.DtMatchRepository;
import com.cerouno.qawadis_api.repository.DtMatchSpecification;
import com.cerouno.qawadis_api.repository.DtUserRepository;
import com.cerouno.qawadis_api.repository.MtUserMatchRepository;
import com.cerouno.qawadis_api.utility.BusinessHelper;
import com.cerouno.qawadis_api.utility.DateTimeHelper;
import com.cerouno.qawadis_api.utility.dtoMapper.DtMatchMapper;
import com.cerouno.qawadis_api.utility.dtoMapper.MtUserMatchMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.*;
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

    @Autowired
    BusinessHelper businessHelper;

    @Override
    public List<DtMatchDto> getMatchList(
            Long sportId, String venue, LocalDate date,
            LocalTime time, Long statusId, Long createdById,
            boolean init) {
        Specification<DtMatch> spec = Specification.where(DtMatchSpecification.hasSport(sportId))
                .and(DtMatchSpecification.hasVenue(venue))
                .and(DtMatchSpecification.hasDate(date))
                .and(DtMatchSpecification.hasTime(time))
                .and(DtMatchSpecification.hasStatus(statusId))
                .and(DtMatchSpecification.createdBy(createdById));

        return DtMatchMapper.toDto(dtMatchRepository.findAll(spec, Sort.by(Sort.Direction.DESC, "createdAt")), init);
    }

    @Override
    public List<DtMatchDto> getMatchListByStatus(Long status, boolean init) {
        return DtMatchMapper.toDto(dtMatchRepository.findByStatus_statusId(status), init);
    }

    @Override
    public DtMatchDto findMatchById(Long id, boolean init) {
        return DtMatchMapper.toDto(dtMatchRepository.findByMatchId(id), init);
    }

    @Override
    public List<MtUserMatchDto> getPlayerListByMatch(Long matchId, Long status, boolean init) {
        if(status != null) {
            return MtUserMatchMapper.toDto(mtUserMatchRepository.findByGame_matchIdAndStatus_statusId(matchId, status), init);
        }else {
            return MtUserMatchMapper.toDto(mtUserMatchRepository.findByGame_matchId(matchId), init);
        }
    }

    @Override
    public Long saveMatch(RequestDto<DtMatch> requestDto, Long userId) {
        DtMatch dtMatch = objectMapper.convertValue(requestDto.getBody(), DtMatch.class);

        LocalDateTime localDateTime = DateTimeHelper.toUtcTimeZone(LocalDateTime.of(dtMatch.getDate(), dtMatch.getTime()));
        dtMatch.setDate(localDateTime.toLocalDate());
        dtMatch.setTime(localDateTime.toLocalTime());

        if(dtMatch.getMatchId() == null){
            dtMatch.setCreatedBy(dtUserRepository.findByUserId(userId));
        }else {
            dtMatch.setMaintainBy(dtUserRepository.findByUserId(userId));
        }
        return dtMatchRepository.save(dtMatch).getMatchId();
    }

    @Override
    public Long saveUserMatch(RequestDto<MtUserMatch> requestDto, Long userId) {
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
