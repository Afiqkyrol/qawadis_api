package com.cerouno.qawadis_api.repository;

import com.cerouno.qawadis_api.entity.LtGeneralStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LtGeneralStatusRepository extends JpaRepository<LtGeneralStatus,Integer> {

    LtGeneralStatus findByStatusId(Integer id);

    List<LtGeneralStatus> findByActiveTrue();

    List<LtGeneralStatus> findByActiveFalse();

    LtGeneralStatus findByCode(String code);

    LtGeneralStatus findByCodeAndActive(String code, Boolean active);

    boolean existsByCode(String code);
}
