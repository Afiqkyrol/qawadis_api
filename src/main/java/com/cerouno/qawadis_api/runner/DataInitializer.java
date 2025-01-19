package com.cerouno.qawadis_api.runner;

import com.cerouno.qawadis_api.entity.DtMatch;
import com.cerouno.qawadis_api.entity.DtUser;
import com.cerouno.qawadis_api.entity.LtGeneralStatus;
import com.cerouno.qawadis_api.entity.LtSport;
import com.cerouno.qawadis_api.repository.DtMatchRepository;
import com.cerouno.qawadis_api.repository.DtUserRepository;
import com.cerouno.qawadis_api.repository.LtGeneralStatusRepository;
import com.cerouno.qawadis_api.repository.LtSportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
@Profile("dev")
public class DataInitializer implements CommandLineRunner {

    private final DtUserRepository dtUserRepository;
    private final LtGeneralStatusRepository ltGeneralStatusRepository;
    private final LtSportRepository ltSportRepository;
    private final DtMatchRepository dtMatchRepository;

    @Autowired
    public DataInitializer(DtUserRepository dtUserRepository, LtGeneralStatusRepository ltGeneralStatusRepository, LtSportRepository ltSportRepository, DtMatchRepository dtMatchRepository) {
        this.dtUserRepository = dtUserRepository;
        this.ltGeneralStatusRepository = ltGeneralStatusRepository;
        this.ltSportRepository = ltSportRepository;
        this.dtMatchRepository = dtMatchRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        //user 1
        DtUser user1 = new DtUser();
        if (dtUserRepository.existsById(1)) {
            user1.setUserId(1);
        }
        user1.setEmail("admin@email.com");
        user1.setUsername("admin");
        user1.setPassword("$2a$10$.CqoxTFkiIWMEcXTDa/e9.c8V47yxhZNoP4.BTC5NEDad4aUkMnLy"); //password admin@123
        dtUserRepository.save(user1);

        //user 2
        DtUser user2 = new DtUser();
        if (dtUserRepository.existsById(2)) {
            user1.setUserId(2);
        }
        user2.setEmail("admin2@email.com");
        user2.setUsername("admin2");
        user2.setPassword("$2a$10$.CqoxTFkiIWMEcXTDa/e9.c8V47yxhZNoP4.BTC5NEDad4aUkMnLy"); //password admin@123
        dtUserRepository.save(user2);

        //user 3
        DtUser user3 = new DtUser();
        if (dtUserRepository.existsById(3)) {
            user1.setUserId(3);
        }
        user3.setEmail("admin3@email.com");
        user3.setUsername("admin3");
        user3.setPassword("$2a$10$.CqoxTFkiIWMEcXTDa/e9.c8V47yxhZNoP4.BTC5NEDad4aUkMnLy"); //password admin@123
        dtUserRepository.save(user3);

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

        //match
        DtMatch match = new DtMatch();
        if(dtMatchRepository.existsById(1)){
            match.setMatchId(1);
            match.setMaintainBy(dtUserRepository.findByUserId(1));
        }else{
            match.setCreatedBy(dtUserRepository.findByUserId(1));
        }
        match.setSport(ltSportRepository.findBySportId(1));
        match.setVenue("venue1");
        match.setAddress("address1");
        match.setDate(LocalDate.now());
        match.setTime(LocalTime.now());
        match.setMaxPlayer(2);
        match.setMap("map1");
        match.setRemark("remark1");
        match.setStatus(ltGeneralStatusRepository.findByStatusId(1));

        dtMatchRepository.save(match);
    }
}
