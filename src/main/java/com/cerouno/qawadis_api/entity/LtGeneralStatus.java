package com.cerouno.qawadis_api.entity;
import com.cerouno.qawadis_api.entity.listener.LtGeneralStatusListener;
import com.cerouno.qawadis_api.repository.DtUserRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Entity
@Table(name = "LT_GENERAL_STATUS")
@EntityListeners(LtGeneralStatusListener.class)
public class LtGeneralStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private Integer statusId;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "active", nullable = false)
    private Boolean active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", nullable = false, updatable = false, referencedColumnName = "user_id")
    private DtUser createdBy;

    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maintain_by", insertable = false, referencedColumnName = "user_id")
    private DtUser maintainBy;

    @Column(name = "maintain_at", insertable = false, columnDefinition = "TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime maintainAt;

    // Constructor
    public LtGeneralStatus(){
        active = true;
    }

    // Getters and setters...
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

    public DtUser getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(DtUser createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreatedBy(Integer id, DtUserRepository dtUserRepository) {
        this.createdBy = dtUserRepository.findByUserId(id);
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public DtUser getMaintainBy() {
        return maintainBy;
    }

    public void setMaintainBy(DtUser maintainBy) {
        this.maintainBy = maintainBy;
    }

    public void setMaintainBy(Integer id, DtUserRepository dtUserRepository) {
        this.maintainBy = dtUserRepository.findByUserId(id);
    }

    public LocalDateTime getMaintainAt() {
        return maintainAt;
    }

    public void setMaintainAt(LocalDateTime maintainAt) {
        this.maintainAt = maintainAt;
    }

    @Override
    public String toString() {
        return "LtGeneralStatus{" +
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

