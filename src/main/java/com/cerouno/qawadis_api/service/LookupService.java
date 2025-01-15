package com.cerouno.qawadis_api.service;

import com.cerouno.qawadis_api.dto.LookupDataDTO;

import java.util.List;

public interface LookupService {
    LookupDataDTO<?> getLookupDataActive (String table, boolean init);
}
