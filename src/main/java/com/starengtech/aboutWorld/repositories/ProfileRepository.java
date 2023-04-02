package com.starengtech.aboutWorld.repositories;

import com.starengtech.aboutWorld.entities.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<UserProfile, Long> {
    Optional<UserProfile> findByEmail(String email);
    Optional<UserProfile> findByEmailAndPassword(String email, String password);
}
