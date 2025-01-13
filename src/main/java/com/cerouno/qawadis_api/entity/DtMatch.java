package com.cerouno.qawadis_api.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "DT_MATCH")
public class DtMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id")
    private Integer matchId;

    @ManyToOne
    @JoinColumn(name = "sport_id", referencedColumnName = "sport_id")
    private LtSport sport;

    @Column(name = "venue", nullable = false)
    private String venue;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "time", nullable = false)
    private LocalTime time;

    @Column(name = "map")
    private String map;

    @Column(name = "remark")
    private String remark;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "status_id")
    private LtGeneralStatus status;

    @ManyToOne
    @JoinColumn(name = "created_by", referencedColumnName = "user_id")
    private DtUser createdBy;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "maintain_by", referencedColumnName = "user_id")
    private DtUser maintainBy;

    @Column(name = "maintain_at")
    private LocalDateTime maintainAt;

    // Constructor
    public DtMatch(){}

    // Getters and setters...
    public Integer getMatchId() {
        return matchId;
    }

    public LtSport getSport() {
        return sport;
    }

    public void setSport(LtSport sport) {
        this.sport = sport;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public LtGeneralStatus getStatus() {
        return status;
    }

    public void setStatus(LtGeneralStatus status) {
        this.status = status;
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
        return "DtMatch{" +
                "matchId=" + matchId +
                ", sport=" + sport +
                ", venue='" + venue + '\'' +
                ", address='" + address + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", map='" + map + '\'' +
                ", remark='" + remark + '\'' +
                ", status=" + status +
                ", createdBy=" + createdBy +
                ", createdAt=" + createdAt +
                ", maintainBy=" + maintainBy +
                ", maintainAt=" + maintainAt +
                '}';
    }
}

