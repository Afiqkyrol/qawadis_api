package com.cerouno.qawadis_api.runner;

import com.cerouno.qawadis_api.entity.*;
import com.cerouno.qawadis_api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final DtUserRepository dtUserRepository;
    private final LtGeneralStatusRepository ltGeneralStatusRepository;
    private final LtSportRepository ltSportRepository;

    @Autowired
    public DataInitializer(DtUserRepository dtUserRepository, LtGeneralStatusRepository ltGeneralStatusRepository, LtSportRepository ltSportRepository) {
        this.dtUserRepository = dtUserRepository;
        this.ltGeneralStatusRepository = ltGeneralStatusRepository;
        this.ltSportRepository = ltSportRepository;
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

        DtUser admin = dtUserRepository.findByUserId(1);

        // --- Status ---
        List<String> statuses = List.of("ACTIVE", "INACTIVE", "CANCELED", "CLOSED");

        for (String status : statuses) {
            boolean exists = ltGeneralStatusRepository.existsByCode(status);
            if (!exists) {
                ltGeneralStatusRepository.save(new LtGeneralStatus(status, status, admin));
            }
        }

        // --- Sport ---
        List<String> sports = List.of("Football", "Futsal", "Badminton", "PingPong", "Pickleball");

        for (String sport : sports) {
            boolean exists = ltSportRepository.existsByDescription(sport);
            if (!exists) {
                ltSportRepository.save(new LtSport(sport, admin));
            }
        }

    }
}
