package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.example.backend.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    
    User findByUsername(String username);  

    Optional<User> findByEmail(String email);  
}
