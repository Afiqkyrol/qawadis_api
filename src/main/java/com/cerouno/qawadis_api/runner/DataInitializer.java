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
            user2.setUserId(2);
        }
        user2.setEmail("admin2@email.com");
        user2.setUsername("admin2");
        user2.setPassword("$2a$10$.CqoxTFkiIWMEcXTDa/e9.c8V47yxhZNoP4.BTC5NEDad4aUkMnLy"); //password admin@123
        dtUserRepository.save(user2);

        //user 3
        DtUser user3 = new DtUser();
        if (dtUserRepository.existsById(3)) {
            user3.setUserId(3);
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
        status.setDescription("Active");
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
        status2.setDescription("Inactive");
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
        status3.setDescription("Cancel");
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

        DtMatch match2 = new DtMatch();
        if(dtMatchRepository.existsById(2)){
            match2.setMatchId(2);
            match2.setMaintainBy(dtUserRepository.findByUserId(1));
        }else{
            match2.setCreatedBy(dtUserRepository.findByUserId(1));
        }
        match2.setSport(ltSportRepository.findBySportId(1));
        match2.setVenue("venue2");
        match2.setAddress("address2");
        match2.setDate(LocalDate.now());
        match2.setTime(LocalTime.now());
        match2.setMaxPlayer(2);
        match2.setMap("map2");
        match2.setRemark("remark2");
        match2.setStatus(ltGeneralStatusRepository.findByStatusId(1));

        dtMatchRepository.save(match2);

        DtMatch match3 = new DtMatch();
        if(dtMatchRepository.existsById(3)){
            match3.setMatchId(3);
            match3.setMaintainBy(dtUserRepository.findByUserId(1));
        }else{
            match3.setCreatedBy(dtUserRepository.findByUserId(1));
        }
        match3.setSport(ltSportRepository.findBySportId(1));
        match3.setVenue("venue3");
        match3.setAddress("address3");
        match3.setDate(LocalDate.now());
        match3.setTime(LocalTime.now());
        match3.setMaxPlayer(2);
        match3.setMap("map3");
        match3.setRemark("remark3");
        match3.setStatus(ltGeneralStatusRepository.findByStatusId(1));

        dtMatchRepository.save(match3);

        DtMatch match4 = new DtMatch();
        if(dtMatchRepository.existsById(4)){
            match4.setMatchId(4);
            match4.setMaintainBy(dtUserRepository.findByUserId(1));
        }else{
            match4.setCreatedBy(dtUserRepository.findByUserId(1));
        }
        match4.setSport(ltSportRepository.findBySportId(1));
        match4.setVenue("venue4");
        match4.setAddress("address4");
        match4.setDate(LocalDate.now());
        match4.setTime(LocalTime.now());
        match4.setMaxPlayer(2);
        match4.setMap("map4");
        match4.setRemark("remark4");
        match4.setStatus(ltGeneralStatusRepository.findByStatusId(1));

        dtMatchRepository.save(match4);
    }
}
