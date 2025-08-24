package com.cerouno.qawadis_api.dto.entityDto;

import java.time.LocalDateTime;

public class MtUserMatchDto {

    private Integer userMatchId;
    private DtMatchDto game;
    private DtUserDto player;
    private LtGeneralStatusDto status;
    private DtUserDto createdBy;
    private LocalDateTime createdAt;
    private DtUserDto maintainBy;
    private LocalDateTime maintainAt;

    public MtUserMatchDto() {
    }

    public LocalDateTime getMaintainAt() {
        return maintainAt;
    }

    public void setMaintainAt(LocalDateTime maintainAt) {
        this.maintainAt = maintainAt;
    }

    public DtUserDto getMaintainBy() {
        return maintainBy;
    }

    public void setMaintainBy(DtUserDto maintainBy) {
        this.maintainBy = maintainBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public DtUserDto getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(DtUserDto createdBy) {
        this.createdBy = createdBy;
    }

    public LtGeneralStatusDto getStatus() {
        return status;
    }

    public void setStatus(LtGeneralStatusDto status) {
        this.status = status;
    }

    public DtUserDto getPlayer() {
        return player;
    }

    public void setPlayer(DtUserDto player) {
        this.player = player;
    }

    public DtMatchDto getGame() {
        return game;
    }

    public void setGame(DtMatchDto game) {
        this.game = game;
    }

    public Integer getUserMatchId() {
        return userMatchId;
    }

    public void setUserMatchId(Integer userMatchId) {
        this.userMatchId = userMatchId;
    }

    @Override
    public String toString() {
        return "MtUserMatchDto{" +
                "userMatchId=" + userMatchId +
                ", game=" + game +
                ", player=" + player +
                ", status=" + status +
                ", createdBy=" + createdBy +
                ", createdAt=" + createdAt +
                ", maintainBy=" + maintainBy +
                ", maintainAt=" + maintainAt +
                '}';
    }
}
