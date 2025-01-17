package com.cerouno.qawadis_api.dto.entity_dto;

import com.cerouno.qawadis_api.entity.DtUser;

import java.time.LocalDateTime;

public class LtGeneralStatusDto {

    private Integer statusId;
    private String code;
    private String description;
    private Boolean active;
    private DtUserDto createdBy;
    private LocalDateTime createdAt;
    private DtUserDto maintainBy;
    private LocalDateTime maintainAt;

    public LtGeneralStatusDto(){}

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public DtUserDto getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(DtUserDto createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public DtUserDto getMaintainBy() {
        return maintainBy;
    }

    public void setMaintainBy(DtUserDto maintainBy) {
        this.maintainBy = maintainBy;
    }

    public LocalDateTime getMaintainAt() {
        return maintainAt;
    }

    public void setMaintainAt(LocalDateTime maintainAt) {
        this.maintainAt = maintainAt;
    }

    @Override
    public String toString() {
        return "LtGeneralStatusDTO{" +
                "statusId=" + statusId +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", active=" + active +
                ", createdBy=" + createdBy +
                ", createdAt=" + createdAt +
                ", maintainBy=" + maintainBy +
                ", maintainAt=" + maintainAt +
                '}';
    }
}

