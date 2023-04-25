package com.starengtech.aboutWorld.services;

import com.starengtech.aboutWorld.entities.AwUser;
import com.starengtech.aboutWorld.repositories.AwUserRepository;
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
public class AwUserService {

    @Autowired
    private AwUserRepository repository;

    public List<AwUser> findAll() {
        return repository.findAll();
    }

    public AwUser findById(Long id) {
        Optional<AwUser> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id) );
    }

    public Optional<AwUser> findByEmail(String email) {
        try{
            return repository.findByEmail(email);
        }catch(DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public List<AwUser> findByRemote() {
        try{
            return repository.findByRemote(true);
        }catch(DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public List<AwUser> findByCountry(String country) {
        try{
            return repository.findByCountry(country);
        }catch(DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public List<AwUser> findByNationality(String nationality) {
        try{
            return repository.findByNationality(nationality);
        }catch(DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public List<AwUser> findByCountryAndNationality(String country, String nationality) {
        try{
            return repository.findByCountryAndNationality(country,nationality);
        }catch(DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Optional<AwUser> findByEmailAndPassword(String email, String password) {
        try{
            String decodedPssd = password.replace("kw*s.x$37tth@$u0K8lE9","").replace("0K2.lp$fzE6qj*tk5lp@$","").trim();
            return repository.findByEmailAndPassword(email,decodedPssd);
        }catch(DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public AwUser insert(AwUser awUser) {
        awUser.setLastLoginTime(Instant.now());
        awUser.setFlActive(true);
        return repository.save(awUser);
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

    public AwUser update(Long id, AwUser profile) {
        try {
            AwUser entity = repository.getById(id);
            entity.setName(profile.getName());
            return repository.save(entity);
        }catch(EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

}
