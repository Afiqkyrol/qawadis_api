package com.cerouno.qawadis_api.service.prod;

import com.cerouno.qawadis_api.constant.AppConstants;
import com.cerouno.qawadis_api.dto.LookupDataDto;
import com.cerouno.qawadis_api.dto.RequestDto;
import com.cerouno.qawadis_api.dto.entityDto.LtGeneralStatusDto;
import com.cerouno.qawadis_api.dto.entityDto.LtSportDto;
import com.cerouno.qawadis_api.entity.LtGeneralStatus;
import com.cerouno.qawadis_api.entity.LtSport;
import com.cerouno.qawadis_api.repository.DtUserRepository;
import com.cerouno.qawadis_api.repository.LtGeneralStatusRepository;
import com.cerouno.qawadis_api.repository.LtSportRepository;
import com.cerouno.qawadis_api.service.LookupService;
import com.cerouno.qawadis_api.utility.dtoMapper.LtGeneralStatusMapper;
import com.cerouno.qawadis_api.utility.dtoMapper.LtSportMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Profile("prod")
public class LookupServiceImpl implements LookupService {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private LtGeneralStatusRepository ltGeneralStatusRepository;

    @Autowired
    private LtSportRepository ltSportRepository;

    @Autowired
    private DtUserRepository dtUserRepository;

    @Override
    public LookupDataDto<?> getLookupData(String table, Boolean active, boolean init) {

        if(table.equals(AppConstants.LT_GENERAL_STATUS_TABLE)){

            List<LtGeneralStatusDto> ltGeneralStatusDtoList = new ArrayList<>();

            if(active == null) ltGeneralStatusDtoList = LtGeneralStatusMapper.toDto(ltGeneralStatusRepository.findAll(),init);
            else if(active) ltGeneralStatusDtoList = LtGeneralStatusMapper.toDto(ltGeneralStatusRepository.findByActiveTrue(),init);
            else ltGeneralStatusDtoList = LtGeneralStatusMapper.toDto(ltGeneralStatusRepository.findByActiveFalse(),init);

            return new LookupDataDto<>(ltGeneralStatusDtoList);

        }else if(table.equals(AppConstants.LT_SPORT_TABLE)){

            List<LtSportDto> ltSportDtoList = new ArrayList<>();

            if(active == null) ltSportDtoList = LtSportMapper.toDto(ltSportRepository.findAll(), init);
            else if(active) ltSportDtoList = LtSportMapper.toDto(ltSportRepository.findByActiveTrue(), init);
            else ltSportDtoList = LtSportMapper.toDto(ltSportRepository.findByActiveFalse(), init);

            return new LookupDataDto<>(ltSportDtoList);

        }else {
            throw new RuntimeException("Table not found: "+table);
        }

    }

    @Override
    public Integer saveLookupData(RequestDto<?> requestDto, String table, Integer userId){

        if(table.equals(AppConstants.LT_GENERAL_STATUS_TABLE)){

            LtGeneralStatus ltGeneralStatus = objectMapper.convertValue(requestDto.getBody(), LtGeneralStatus.class);
            if(ltGeneralStatus.getStatusId() == null){
                ltGeneralStatus.setCreatedBy(dtUserRepository.findByUserId(userId));
            }else{
                ltGeneralStatus.setMaintainBy(dtUserRepository.findByUserId(userId));
            }
            return ltGeneralStatusRepository.save(ltGeneralStatus).getStatusId();

        }else if(table.equals(AppConstants.LT_SPORT_TABLE)){

            LtSport ltSport = objectMapper.convertValue(requestDto.getBody(), LtSport.class);
            if(ltSport.getSportId() == null){
                ltSport.setCreatedBy(dtUserRepository.findByUserId(userId));
            }else{
                ltSport.setMaintainBy(dtUserRepository.findByUserId(userId));
            }
            return ltSportRepository.save(ltSport).getSportId();

        }else{
            throw new RuntimeException("Table not found: "+table);
        }

    }


}
