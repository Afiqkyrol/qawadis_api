package com.cerouno.qawadis_api.repository;

import com.cerouno.qawadis_api.constant.AppConstants;
import com.cerouno.qawadis_api.entity.DtMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface DtMatchRepository extends JpaRepository<DtMatch,Integer>, JpaSpecificationExecutor<DtMatch> {

    List<DtMatch> findByStatus_statusId(Integer id);

    DtMatch findByMatchId(Integer id);

    Integer countByStatus_statusId(Integer id);

    //Custom DAO
    @Query("SELECT m FROM DtMatch m " + "WHERE (m.date < :dateNow OR (m.date = :today AND m.time < :timeNow)) " + "AND m.status.statusId = 1")
    List<DtMatch> findExpiredMatches(@Param("dateNow") LocalDate dateNow, @Param("timeNow") LocalTime timeNow);
}
