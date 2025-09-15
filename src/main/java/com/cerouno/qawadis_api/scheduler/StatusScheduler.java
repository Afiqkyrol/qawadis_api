package com.cerouno.qawadis_api.scheduler;

import com.cerouno.qawadis_api.constant.AppConstants;
import com.cerouno.qawadis_api.entity.DtMatch;
import com.cerouno.qawadis_api.entity.LtGeneralStatus;
import com.cerouno.qawadis_api.repository.DtMatchRepository;
import com.cerouno.qawadis_api.repository.LtGeneralStatusRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Component
public class StatusScheduler {
    private static final Logger logger = LoggerFactory.getLogger(StatusScheduler.class);

    private final DtMatchRepository dtMatchRepository;
    private final LtGeneralStatusRepository ltGeneralStatusRepository;

    public StatusScheduler(DtMatchRepository dtMatchRepository,
                           LtGeneralStatusRepository ltGeneralStatusRepository) {
        this.dtMatchRepository = dtMatchRepository;
        this.ltGeneralStatusRepository = ltGeneralStatusRepository;
    }

    @Scheduled(cron = "0 * * * * *")
    @Transactional
    public void updateMatchStatus() {
        List<DtMatch> activeMatches = dtMatchRepository.findByStatus_statusId(AppConstants.GSTS_ACTIVE);
        LocalDateTime now = LocalDateTime.now(ZoneOffset.UTC);
        int totalActive = activeMatches.size();

        List<DtMatch> matchesToUpdate = activeMatches.stream()
                                        .filter(m -> m.getMatchDateTime().isBefore(now))
                                        .toList();

        if (!matchesToUpdate.isEmpty()) {
            LtGeneralStatus closedStatus = ltGeneralStatusRepository.findByStatusId(AppConstants.GSTS_CLOSED);
            matchesToUpdate.forEach(m -> m.setStatus(closedStatus));
            dtMatchRepository.saveAll(matchesToUpdate);
        }

        logger.info("StatusScheduler Triggered (1 Minute Interval): Total active matches = {}, Status changes = {}, Matches saved = {}",
                    totalActive, matchesToUpdate.size(), matchesToUpdate.size());
    }

}
