package com.cerouno.qawadis_api.repository;

import com.cerouno.qawadis_api.entity.DtMatch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DtMatchRepository extends JpaRepository<DtMatch,Integer> {

    List<DtMatch> findByStatus_statusId(Integer id);

    DtMatch findByMatchId(Integer id);
}
