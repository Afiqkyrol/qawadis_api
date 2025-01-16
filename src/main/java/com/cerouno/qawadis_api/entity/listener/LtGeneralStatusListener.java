package com.cerouno.qawadis_api.entity.listener;

import com.cerouno.qawadis_api.entity.LtGeneralStatus;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class LtGeneralStatusListener {

    @PrePersist
    public void prePersist(LtGeneralStatus entity){
        entity.setCreatedAt(LocalDateTime.now());
    }

    @PreUpdate
    public void preUpdate(LtGeneralStatus entity){
        entity.setMaintainAt(LocalDateTime.now());
    }
}
