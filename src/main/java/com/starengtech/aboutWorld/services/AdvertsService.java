package com.starengtech.aboutWorld.services;

import com.starengtech.aboutWorld.entities.Adverts;
import com.starengtech.aboutWorld.entities.Adverts;
import com.starengtech.aboutWorld.entities.AwUser;
import com.starengtech.aboutWorld.repositories.AdvertsRepository;
import com.starengtech.aboutWorld.services.exceptions.DatabaseException;
import com.starengtech.aboutWorld.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class AdvertsService {

    @Autowired
    private AdvertsRepository repository;

    public List<Adverts> findAll() {
        return repository.findAll();
    }

    public Adverts findById(Long id) {
        Optional<Adverts> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id) );
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }catch(EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }catch(DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Adverts update(Long id, Adverts profile) {
        try {
            Adverts entity = repository.getById(id);
            entity.setTitle(profile.getTitle());
            return repository.save(entity);
        }catch(EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public Adverts insert(Adverts adverts) {
        adverts.setInsertTime(Instant.now());
        adverts.setCountry((adverts.getAwUser().getCountry()));
        adverts.setNationality(adverts.getAwUser().getNationality());
        return repository.save(adverts);
    }

    //---

    public List<Adverts> findByAwUser(AwUser awUser) {
        try{
            return repository.findByAwUser(awUser);
        }catch(DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public List<Adverts> findByCountry(String country) {
        try{
            return repository.findByCountry(country);
        }catch(DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public List<Adverts> findByNationality(String nationality) {
        try{
            return repository.findByNationality(nationality);
        }catch(DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public List<Adverts> findByCountryAndNationality(String country, String nationality) {
        try{
            return repository.findByCountryAndNationality(country,nationality);
        }catch(DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

}
