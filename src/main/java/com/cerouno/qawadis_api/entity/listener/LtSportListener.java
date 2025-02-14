package com.cerouno.qawadis_api.entity.listener;

import com.cerouno.qawadis_api.entity.LtSport;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class LtSportListener {

    @PrePersist
    public void prePersist(LtSport entity){
        entity.setCreatedAt(LocalDateTime.now());
    }

    @PreUpdate
    public void preUpdate(LtSport entity){
        entity.setMaintainAt(LocalDateTime.now());
    }

}
