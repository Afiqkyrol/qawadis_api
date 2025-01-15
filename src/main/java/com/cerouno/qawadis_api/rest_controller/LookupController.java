package com.cerouno.qawadis_api.rest_controller;

import com.cerouno.qawadis_api.constants.AppConstants;
import com.cerouno.qawadis_api.dto.LookupDataDTO;
import com.cerouno.qawadis_api.service.LookupService;
import com.cerouno.qawadis_api.utility.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lookups")
public class LookupController {

    private final LookupService lookupService;

    @Autowired
    public LookupController(LookupService lookupService) {
        this.lookupService = lookupService;
    }

    @GetMapping("/item")
    public ResponseEntity<?> getLookupData(@RequestParam("table") String table, @RequestParam("init") boolean init) {
        try {
            LookupDataDTO<?> lookupData = lookupService.getLookupDataActive(table, init);
            return ResponseBuilder.success(AppConstants.SUCCESS_MSG, lookupData);
        }catch (Exception e){
            return ResponseBuilder.error(AppConstants.ERROR_MSG, e.getCause().getMessage());
        }
    }
}
