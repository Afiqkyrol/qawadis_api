package com.cerouno.qawadis_api.entity.listener;

import com.cerouno.qawadis_api.entity.MtUserMatch;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MtUserMatchListener {

    @PrePersist
    public void prePersist(MtUserMatch entity){
        entity.setCreatedAt(LocalDateTime.now());
    }

    @PreUpdate
    public void preUpdate(MtUserMatch entity){
        entity.setMaintainAt(LocalDateTime.now());
    }

}
