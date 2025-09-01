package com.cerouno.qawadis_api.entity.listener;

import com.cerouno.qawadis_api.entity.DtUser;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Component
public class DtUserListener {

    @PrePersist
    public void prePersist(DtUser entity){
        entity.setCreatedAt(LocalDateTime.now(ZoneOffset.UTC));
    }

    @PreUpdate
    public void preUpdate(DtUser entity){
        entity.setMaintainAt(LocalDateTime.now(ZoneOffset.UTC));
    }

}
