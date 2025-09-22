package com.cerouno.qawadis_api.entity;

import com.cerouno.qawadis_api.entity.listener.LtSportListener;
import com.cerouno.qawadis_api.repository.DtUserRepository;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "LT_SPORT")
@EntityListeners(LtSportListener.class)
public class LtSport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sport_id")
    private Long sportId;

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
    public LtSport() {
        active = true;
    }

    public LtSport(String description, DtUser createdBy) {
        this.description = description;
        this.active = true;
        this.createdBy = createdBy;
    }

    // Getters and setters...
    public Long getSportId() {
        return sportId;
    }

    public void setSportId(Long sportId) {
        this.sportId = sportId;
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

    public LocalDateTime getMaintainAt() {
        return maintainAt;
    }

    public void setMaintainAt(LocalDateTime maintainAt) {
        this.maintainAt = maintainAt;
    }

    @Override
    public String toString() {
        return "LtSport{" +
                "sportId=" + sportId +
                ", description='" + description + '\'' +
                ", active=" + active +
                ", createdBy=" + createdBy +
                ", createdAt=" + createdAt +
                ", maintainBy=" + maintainBy +
                ", maintainAt=" + maintainAt +
                '}';
    }
}
