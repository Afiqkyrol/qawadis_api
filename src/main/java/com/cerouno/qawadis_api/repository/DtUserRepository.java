package com.cerouno.qawadis_api.repository;

import com.cerouno.qawadis_api.entity.DtUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DtUserRepository extends JpaRepository<DtUser,Long> {
    DtUser findByUserId(Long userId);

    Optional<DtUser> findByEmail(String email);

    Optional<DtUser> findByUsername(String username);

    boolean existsByEmail(String email);
}
