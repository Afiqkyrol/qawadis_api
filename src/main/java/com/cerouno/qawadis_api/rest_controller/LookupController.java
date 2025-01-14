package com.cerouno.qawadis_api.rest_controller;

import com.cerouno.qawadis_api.constants.AppConstants;
import com.cerouno.qawadis_api.dto.ApiResponse;
import com.cerouno.qawadis_api.dto.LookupDataDTO;
import com.cerouno.qawadis_api.service.LookupService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ApiResponse<?> getLookupData (@RequestParam("table") String table){
        try {
            LookupDataDTO<?> lookupData = lookupService.getLookupDataActive(table);
            return ApiResponse.success(lookupData, AppConstants.SUCCESS_MSG);
        }catch (Exception e){
            return ApiResponse.internalServerError(AppConstants.ERROR_MSG, e.getMessage());
        }
    }
}
