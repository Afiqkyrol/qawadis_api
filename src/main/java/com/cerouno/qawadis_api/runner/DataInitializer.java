package com.cerouno.qawadis_api.runner;

import com.cerouno.qawadis_api.entity.DtUser;
import com.cerouno.qawadis_api.entity.LtGeneralStatus;
import com.cerouno.qawadis_api.entity.LtSport;
import com.cerouno.qawadis_api.repository.DtUserRepository;
import com.cerouno.qawadis_api.repository.LtGeneralStatusRepository;
import com.cerouno.qawadis_api.repository.LtSportRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataInitializer implements CommandLineRunner {

    private final DtUserRepository dtUserRepository;
    private final LtGeneralStatusRepository ltGeneralStatusRepository;
    private final LtSportRepository ltSportRepository;

    public DataInitializer(DtUserRepository dtUserRepository, LtGeneralStatusRepository ltGeneralStatusRepository, LtSportRepository ltSportRepository) {
        this.dtUserRepository = dtUserRepository;
        this.ltGeneralStatusRepository = ltGeneralStatusRepository;
        this.ltSportRepository = ltSportRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (!dtUserRepository.existsById(1)) {
            DtUser user1 = new DtUser();
//            user1.setUserId(1);
            user1.setEmail("admin@email.com");
            user1.setUsername("admin");
            user1.setPassword("admin@123");

            dtUserRepository.save(user1);
        }

        if (!ltGeneralStatusRepository.existsByCode("ACTIVE") && !ltGeneralStatusRepository.existsById(1)) {
            LtGeneralStatus status = new LtGeneralStatus();
//            status.setStatusId(1);
            status.setCode("ACTIVE");
            status.setDescription("ACTIVE");
            status.setCreatedBy(dtUserRepository.findByUserId(1));

            ltGeneralStatusRepository.save(status);
        }

        if (!ltSportRepository.existsById(1)) {
            LtSport sport = new LtSport();
//            sport.setSportId(1);
            sport.setDescription("Futsal");
            sport.setCreatedBy(dtUserRepository.findByUserId(1));

            ltSportRepository.save(sport);
        }
    }
}
