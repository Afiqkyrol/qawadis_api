package com.cerouno.qawadis_api.repository;

import com.cerouno.qawadis_api.entity.LtGeneralStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LtGeneralStatusRepository extends JpaRepository<LtGeneralStatus,Integer> {

    List<LtGeneralStatus> findByActiveTrue();

    LtGeneralStatus findByCode(String code);

    LtGeneralStatus findByCodeAndActive(String code, Boolean active);

    boolean existsByCode(String code);
}
