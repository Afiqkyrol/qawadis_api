package com.cerouno.qawadis_api.scheduler;

import com.cerouno.qawadis_api.constant.AppConstants;
import com.cerouno.qawadis_api.entity.DtMatch;
import com.cerouno.qawadis_api.repository.DtMatchRepository;
import com.cerouno.qawadis_api.repository.LtGeneralStatusRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Component
public class StatusScheduler {

    private final DtMatchRepository dtMatchRepository;
    private final LtGeneralStatusRepository ltGeneralStatusRepository;

    public  StatusScheduler (DtMatchRepository dtMatchRepository, LtGeneralStatusRepository ltGeneralStatusRepository){
        this.dtMatchRepository = dtMatchRepository;
        this.ltGeneralStatusRepository = ltGeneralStatusRepository;
    }

    @Scheduled(cron = "0 * * * * *")
    public void updateMatchStatus(){
        System.out.println("[INFO LOG] StatusScheduler started (every 1 minute): Updating DtMatch.status");
        List<DtMatch> dtMatchList = dtMatchRepository.findByStatus_statusId(AppConstants.GSTS_ACTIVE);
        LocalDateTime currentLocalDateTime = LocalDateTime.now(ZoneOffset.UTC);

        if(dtMatchList != null && !dtMatchList.isEmpty()){
            for(DtMatch dtMatch : dtMatchList){
                if(dtMatch.getMatchDateTime().isBefore(currentLocalDateTime)){
                    dtMatch.setStatus(ltGeneralStatusRepository.findByStatusId(AppConstants.GSTS_CLOSED));
                }
            }
            dtMatchRepository.saveAll(dtMatchList);
        }
    }
}
