package com.cerouno.qawadis_api.service;

import com.cerouno.qawadis_api.constants.AppConstants;
import com.cerouno.qawadis_api.dto.LookupDataDto;
import com.cerouno.qawadis_api.dto.RequestDto;
import com.cerouno.qawadis_api.dto.entity_dto.LtGeneralStatusDto;
import com.cerouno.qawadis_api.entity.LtGeneralStatus;
import com.cerouno.qawadis_api.entity.LtSport;
import com.cerouno.qawadis_api.repository.LtGeneralStatusRepository;
import com.cerouno.qawadis_api.repository.LtSportRepository;
import com.cerouno.qawadis_api.utility.dto_mapper.LtGeneralStatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class LookupServiceImpl implements LookupService{

    private final LtGeneralStatusRepository ltGeneralStatusRepository;
    private final LtSportRepository ltSportRepository;

    @Autowired
    public LookupServiceImpl(LtGeneralStatusRepository ltGeneralStatusRepository, LtSportRepository ltSportRepository) {
        this.ltGeneralStatusRepository = ltGeneralStatusRepository;
        this.ltSportRepository = ltSportRepository;
    }

    @Override
    public LookupDataDto<?> getLookupDataActive(String table, boolean init) {

        if(table.equals(AppConstants.LT_GENERAL_STATUS_TABLE)){

            List<LtGeneralStatusDto> ltGeneralStatusDtoList = LtGeneralStatusMapper.toDto(ltGeneralStatusRepository.findByActiveTrue(),init);
            return new LookupDataDto<>(ltGeneralStatusDtoList);

        }else if(table.equals(AppConstants.LT_SPORT_TABLE)){

            return new LookupDataDto<>(ltSportRepository.findByActiveTrue());

        }

        return new LookupDataDto<>(Collections.emptyList());

    }

    @Override
    public Integer saveLookupData(RequestDto lookupData, String table){

        if(table.equals(AppConstants.LT_GENERAL_STATUS_TABLE)){
            LtGeneralStatus ltGeneralStatus = (LtGeneralStatus) lookupData.getData();
            return ltGeneralStatusRepository.save(ltGeneralStatus).getStatusId();
        }else if(table.equals(AppConstants.LT_SPORT_TABLE)){
            LtSport ltSport = (LtSport) lookupData.getData();
            return ltSportRepository.save(ltSport).getSportId();
        }{
            throw new RuntimeException("Table not found: "+table);
        }

    }


}
