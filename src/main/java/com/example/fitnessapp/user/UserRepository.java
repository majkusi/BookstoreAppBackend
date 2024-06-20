package com.example.fitnessapp.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(Object email);

    boolean existsUserModelByUsername(String userName);

    boolean existsUserModelByEmail(String email);
//1:21:24
}
