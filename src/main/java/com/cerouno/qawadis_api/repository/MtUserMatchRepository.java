package com.cerouno.qawadis_api.repository;

import com.cerouno.qawadis_api.entity.MtUserMatch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MtUserMatchRepository extends JpaRepository<MtUserMatch, Integer> {

    Integer countByGame_matchIdAndStatus_statusId (Integer matchId, Integer statusId);
}
