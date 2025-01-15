package com.cerouno.qawadis_api.rest_controller;

import com.cerouno.qawadis_api.constants.AppConstants;
import com.cerouno.qawadis_api.dto.LookupDataDto;
import com.cerouno.qawadis_api.dto.RequestDto;
import com.cerouno.qawadis_api.service.LookupService;
import com.cerouno.qawadis_api.utility.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lookups")
public class LookupController {

    private final LookupService lookupService;

    @Autowired
    public LookupController(LookupService lookupService) {
        this.lookupService = lookupService;
    }

    @GetMapping("/item")
    public ResponseEntity<?> getLookupDataActive(@RequestParam("table") String table, @RequestParam("init") boolean init) {
        try {
            LookupDataDto<?> lookupData = lookupService.getLookupDataActive(table, init);
            return ResponseBuilder.success(AppConstants.SUCCESS_MSG, lookupData);
        }catch (Exception e){
            return ResponseBuilder.error(AppConstants.ERROR_MSG, e.getMessage());
        }
    }

    @PostMapping("/item")
    public ResponseEntity<?> saveLookupData(@RequestBody RequestDto requestDto, @RequestParam("table") String table){
        try {
            return ResponseBuilder.success(AppConstants.SUCCESS_MSG, lookupService.saveLookupData(requestDto, table));
        } catch (Exception e) {
            return ResponseBuilder.error(AppConstants.ERROR_MSG, e.getMessage());
        }
    }
}
