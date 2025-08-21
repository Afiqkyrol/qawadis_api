package com.cerouno.qawadis_api.repository;

import com.cerouno.qawadis_api.entity.LtSport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LtSportRepository extends JpaRepository<LtSport,Integer> {

    LtSport findBySportId(Integer id);

    List<LtSport> findByActiveTrue();

    List<LtSport> findByActiveFalse();

}
