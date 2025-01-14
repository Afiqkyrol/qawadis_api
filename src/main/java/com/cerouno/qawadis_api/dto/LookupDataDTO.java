package com.cerouno.qawadis_api.dto;

import java.util.List;

public class LookupDataDTO<T> {

    private List<T> lookupData;

    public LookupDataDTO(List<T> lookupData) {
        this.lookupData = lookupData;
    }

    public List<T> getLookupData() {
        return lookupData;
    }

    public void setLookupData(List<T> lookupData) {
        this.lookupData = lookupData;
    }
}

