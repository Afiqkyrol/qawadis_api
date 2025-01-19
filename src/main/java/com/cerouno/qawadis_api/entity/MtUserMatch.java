package com.cerouno.qawadis_api.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "MT_USER_MATCH")
public class MtUserMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_match_id")
    private Integer userMatchId;

    @ManyToOne
    @JoinColumn(name = "game", updatable = false, referencedColumnName = "match_id")
    private DtMatch game;

    @ManyToOne
    @JoinColumn(name = "player", updatable = false, referencedColumnName = "user_id")
    private DtUser player;

    @ManyToOne
    @JoinColumn(name = "status", referencedColumnName = "status_id")
    private LtGeneralStatus status;

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

    public MtUserMatch(){}

    public Integer getUserMatchId() {
        return userMatchId;
    }

    public void setUserMatchId(Integer userMatchId) {
        this.userMatchId = userMatchId;
    }

    public DtMatch getGame() {
        return game;
    }

    public void setGame(DtMatch game) {
        this.game = game;
    }

    public DtUser getPlayer() {
        return player;
    }

    public void setPlayer(DtUser player) {
        this.player = player;
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
        return "MtUserMatch{" +
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
