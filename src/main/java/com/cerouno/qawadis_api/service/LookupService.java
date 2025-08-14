package com.cerouno.qawadis_api.service;

import com.cerouno.qawadis_api.dto.LookupDataDto;
import com.cerouno.qawadis_api.dto.RequestDto;

public interface LookupService {

    LookupDataDto<?> getLookupData (String table, Boolean active, boolean init);

    Integer saveLookupData (RequestDto<?> lookupData, String table, Integer userId);
}
