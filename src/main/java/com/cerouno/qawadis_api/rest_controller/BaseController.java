package com.cerouno.qawadis_api.rest_controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @GetMapping("/")
    public String root(){
        return "qawadis_api";
    }
}
