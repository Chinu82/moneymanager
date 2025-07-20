package com.managemoney.repository;

import com.managemoney.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {
    //select * from tbl_profiles where email = ?
    Optional<ProfileRepository> findByEmail(String email);
}
