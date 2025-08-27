package com.cerouno.qawadis_api.repository;

import com.cerouno.qawadis_api.entity.MtUserMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MtUserMatchRepository extends JpaRepository<MtUserMatch, Integer> {

    MtUserMatch findByUserMatchId (Integer id);

    Integer countByGame_matchIdAndStatus_statusId (Integer matchId, Integer statusId);

    MtUserMatch findByGame_matchIdAndStatus_statusIdAndPlayer_userId (Integer matchId, Integer statusId, Integer userId);

    List<MtUserMatch> findByGame_matchIdAndStatus_statusId (Integer userMatchId, Integer statusId);

    List<MtUserMatch> findByGame_matchId (Integer userMatchId);
}
