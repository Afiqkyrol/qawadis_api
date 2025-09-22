package com.cerouno.qawadis_api.repository;

import com.cerouno.qawadis_api.entity.MtUserMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MtUserMatchRepository extends JpaRepository<MtUserMatch, Long> {

    MtUserMatch findByUserMatchId (Long id);

    Long countByGame_matchIdAndStatus_statusId (Long matchId, Long statusId);

    MtUserMatch findByGame_matchIdAndStatus_statusIdAndPlayer_userId (Long matchId, Long statusId, Long userId);

    List<MtUserMatch> findByGame_matchIdAndStatus_statusId (Long userMatchId, Long statusId);

    List<MtUserMatch> findByGame_matchId (Long userMatchId);
}
