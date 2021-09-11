package com.example.demo.systemuser;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SystemUserRepository extends JpaRepository<SystemUser, Long> {

    Optional<SystemUser> findByUsername(String username);
    Optional<SystemUser> findByMail(String mail);

}
