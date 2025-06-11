package com.rollerspeed.rollerspeed.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rollerspeed.rollerspeed.Models.user;


@Repository
public interface userRepository extends JpaRepository<user, Long> {
    
Optional<user> findByCorreo(String correo);

}
