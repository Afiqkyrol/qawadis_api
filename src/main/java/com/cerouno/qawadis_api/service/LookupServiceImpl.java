package com.cerouno.qawadis_api.service;

import com.cerouno.qawadis_api.constants.AppConstants;
import com.cerouno.qawadis_api.dto.LookupDataDTO;
import com.cerouno.qawadis_api.entity.LtGeneralStatus;
import com.cerouno.qawadis_api.entity.LtSport;
import com.cerouno.qawadis_api.repository.LtGeneralStatusRepository;
import com.cerouno.qawadis_api.repository.LtSportRepository;
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
    public LookupDataDTO<?> getLookupDataActive(String table) {

        if(table.equals(AppConstants.LT_GENERAL_STATUS_TABLE)){
            return new LookupDataDTO<>(ltGeneralStatusRepository.findByActiveTrue());
        }

        if(table.equals(AppConstants.LT_SPORT_TABLE)){
            return new LookupDataDTO<>(ltSportRepository.findByActiveTrue());
        }

        return new LookupDataDTO<>(Collections.emptyList());

    }
}
