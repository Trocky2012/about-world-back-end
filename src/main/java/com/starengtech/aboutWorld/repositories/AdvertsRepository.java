package com.starengtech.aboutWorld.repositories;

import com.starengtech.aboutWorld.entities.Adverts;
import com.starengtech.aboutWorld.entities.AwUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdvertsRepository extends JpaRepository<Adverts, Long> {
    List<Adverts> findByAwUser(AwUser awUser);
    List<Adverts> findByCountry(String country);
    List<Adverts> findByNationality(String nationality);
    List<Adverts> findByCountryAndNationality(String country, String nationality);
}
