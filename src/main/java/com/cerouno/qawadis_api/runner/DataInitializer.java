package com.cerouno.qawadis_api.runner;

import com.cerouno.qawadis_api.entity.DtUser;
import com.cerouno.qawadis_api.entity.LtGeneralStatus;
import com.cerouno.qawadis_api.entity.LtSport;
import com.cerouno.qawadis_api.repository.DtUserRepository;
import com.cerouno.qawadis_api.repository.LtGeneralStatusRepository;
import com.cerouno.qawadis_api.repository.LtSportRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Profile("dev")
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

        //user
        DtUser user1 = new DtUser();
        if (dtUserRepository.existsById(1)) {
            user1.setUserId(1);
        }
        user1.setEmail("admin@email.com");
        user1.setUsername("admin");
        user1.setPassword("$2a$10$.CqoxTFkiIWMEcXTDa/e9.c8V47yxhZNoP4.BTC5NEDad4aUkMnLy");
        dtUserRepository.save(user1);

        //status active
        LtGeneralStatus status = new LtGeneralStatus();
        if (ltGeneralStatusRepository.existsById(1)) {
            status.setStatusId(1);
            status.setMaintainBy(dtUserRepository.findByUserId(1));
        }else{
            status.setCreatedBy(dtUserRepository.findByUserId(1));
        }
        status.setCode("ACTIVE");
        status.setDescription("ACTIVE");
        ltGeneralStatusRepository.save(status);

        //status inactive
        LtGeneralStatus status2 = new LtGeneralStatus();
        if (ltGeneralStatusRepository.existsById(2)) {
            status2.setStatusId(2);
            status2.setMaintainBy(dtUserRepository.findByUserId(1));
        }else{
            status2.setCreatedBy(dtUserRepository.findByUserId(1));
        }
        status2.setCode("INACTIVE");
        status2.setDescription("INACTIVE");
        ltGeneralStatusRepository.save(status2);

        //status cancel
        LtGeneralStatus status3 = new LtGeneralStatus();
        if (ltGeneralStatusRepository.existsById(3)) {
            status3.setStatusId(3);
            status3.setMaintainBy(dtUserRepository.findByUserId(1));
        }else{
            status3.setCreatedBy(dtUserRepository.findByUserId(1));
        }
        status3.setCode("CANCEL");
        status3.setDescription("CANCEL");
        ltGeneralStatusRepository.save(status3);

        //sport
        LtSport sport = new LtSport();
        if (ltSportRepository.existsById(1)) {
            sport.setSportId(1);
            sport.setMaintainBy(dtUserRepository.findByUserId(1));
        }else{
            sport.setCreatedBy(dtUserRepository.findByUserId(1));
        }
        sport.setDescription("Futsal");
        sport.setCreatedBy(dtUserRepository.findByUserId(1));
        ltSportRepository.save(sport);
    }
}
