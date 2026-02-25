package com.example.workintech.ecommege.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.workintech.ecommege.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findByVerificationToken(String verificationToken);


}

