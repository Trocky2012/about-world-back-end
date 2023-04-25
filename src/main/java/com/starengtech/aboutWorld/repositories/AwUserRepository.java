package com.starengtech.aboutWorld.repositories;

import com.starengtech.aboutWorld.entities.AwUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AwUserRepository extends JpaRepository<AwUser, Long> {
    Optional<AwUser> findByEmail(String email);
    Optional<AwUser> findByEmailAndPassword(String email, String password);
    List<AwUser> findByRemote(boolean remote);
    List<AwUser> findByCountry(String country);
    List<AwUser> findByNationality(String nationality);
    List<AwUser> findByCountryAndNationality(String country, String nationality);

}
