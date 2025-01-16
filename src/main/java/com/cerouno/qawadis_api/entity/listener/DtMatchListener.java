package com.cerouno.qawadis_api.entity.listener;

import com.cerouno.qawadis_api.entity.DtMatch;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DtMatchListener {

    @PrePersist
    public void prePersist(DtMatch entity){
        entity.setCreatedAt(LocalDateTime.now());
    }

    @PreUpdate
    public void preUpdate(DtMatch entity){
        entity.setMaintainAt(LocalDateTime.now());
    }
}
