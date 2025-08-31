package com.cerouno.qawadis_api.repository;

import com.cerouno.qawadis_api.entity.DtMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DtMatchRepository extends JpaRepository<DtMatch,Integer>, JpaSpecificationExecutor<DtMatch> {

    List<DtMatch> findByStatus_statusId(Integer id);

    DtMatch findByMatchId(Integer id);

    Integer countByStatus_statusId(Integer id);
}
