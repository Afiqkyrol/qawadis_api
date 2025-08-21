package com.cerouno.qawadis_api.repository;

import com.cerouno.qawadis_api.entity.VwTableCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VwTableCodeRepository extends JpaRepository<VwTableCode, String> {
}
