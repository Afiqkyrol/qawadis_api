package com.cerouno.qawadis_api.dto.entityDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DtMatchDto {

    private Long matchId;
    private LtSportDto sport;
    private String venue;
    private String address;
    private LocalDate date;
    private LocalTime time;
    private Integer maxPlayer;
    private String mapShareLink;
    private String mapEmbedLink;
    private String remark;
    private LtGeneralStatusDto status;
    private DtUserDto createdBy;
    private LocalDateTime createdAt;
    private DtUserDto maintainBy;
    private LocalDateTime maintainAt;

    public DtMatchDto (){}

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public LtSportDto getSport() {
        return sport;
    }

    public void setSport(LtSportDto sport) {
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

    public Integer getMaxPlayer() {
        return maxPlayer;
    }

    public void setMaxPlayer(Integer maxPlayer) {
        this.maxPlayer = maxPlayer;
    }

    public String getMapShareLink() {
        return mapShareLink;
    }

    public void setMapShareLink(String mapShareLink) {
        this.mapShareLink = mapShareLink;
    }

    public String getMapEmbedLink() {
        return mapEmbedLink;
    }

    public void setMapEmbedLink(String mapEmbedLink) {
        this.mapEmbedLink = mapEmbedLink;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public LtGeneralStatusDto getStatus() {
        return status;
    }

    public void setStatus(LtGeneralStatusDto status) {
        this.status = status;
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
        return "DtMatchDto{" +
                "matchId=" + matchId +
                ", sport=" + sport +
                ", venue='" + venue + '\'' +
                ", address='" + address + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", mapShareLink='" + mapShareLink + '\'' +
                ", remark='" + remark + '\'' +
                ", status=" + status +
                ", createdBy=" + createdBy +
                ", createdAt=" + createdAt +
                ", maintainBy=" + maintainBy +
                ", maintainAt=" + maintainAt +
                '}';
    }
}
