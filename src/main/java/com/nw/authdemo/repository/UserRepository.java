package com.nw.authdemo.repository;

import com.nw.authdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);

    @Transactional()
    @Modifying
    @Query("UPDATE User u SET u.enabled=TRUE,u.locked=FALSE WHERE u.email=?1")
    int enableUser(String email);
}
