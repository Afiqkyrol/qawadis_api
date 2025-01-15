package com.cerouno.qawadis_api.dto;

import java.util.List;

public class LookupDataDto<T> {

    private List<T> lookupData;

    public LookupDataDto(List<T> lookupData) {
        this.lookupData = lookupData;
    }

    public List<T> getLookupData() {
        return lookupData;
    }

    public void setLookupData(List<T> lookupData) {
        this.lookupData = lookupData;
    }
}

