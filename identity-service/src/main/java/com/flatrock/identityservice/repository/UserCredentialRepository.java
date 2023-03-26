package com.flatrock.identityservice.repository;

import com.flatrock.identityservice.entity.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.Set;

public interface UserCredentialRepository  extends JpaRepository<UserCredential,Integer> {
    Optional<UserCredential> findByUsername(String username);
    @Query("SELECT u.roles FROM UserCredential u WHERE u.username = :username")
    Set<String> findRolesByUsername(@Param("username") String username);
}