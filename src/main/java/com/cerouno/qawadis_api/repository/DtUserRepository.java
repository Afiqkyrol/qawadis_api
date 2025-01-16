package com.cerouno.qawadis_api.repository;

import com.cerouno.qawadis_api.entity.DtUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DtUserRepository extends JpaRepository<DtUser,Integer> {
    DtUser findByUserId(Integer userId);
}
