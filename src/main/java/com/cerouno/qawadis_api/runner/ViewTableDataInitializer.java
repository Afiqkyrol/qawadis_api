package com.cerouno.qawadis_api.runner;

import com.cerouno.qawadis_api.entity.VwTableCode;
import com.cerouno.qawadis_api.repository.VwTableCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ViewTableDataInitializer implements CommandLineRunner {
    @Autowired
    private final VwTableCodeRepository vwTableCodeRepository; // JPA repository for the table

    public ViewTableDataInitializer(VwTableCodeRepository vwTableCodeRepository) {
        this.vwTableCodeRepository = vwTableCodeRepository;
    }

    @Override
    public void run(String... args) {

        vwTableCodeRepository.deleteAll();

        vwTableCodeRepository.saveAll(List.of(
                new VwTableCode("LT001", "LT_GENERAL_STATUS_TABLE", "General Status Table"),
                new VwTableCode("LT002", "LT_SPORT_TABLE", "Sport table")
        ));
    }
}
