package com.starengtech.aboutWorld.services;

import com.starengtech.aboutWorld.entities.UserProfile;
import com.starengtech.aboutWorld.repositories.ProfileRepository;
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
public class ProfileService {

    @Autowired
    private ProfileRepository repository;

    public List<UserProfile> findAll() {
        return repository.findAll();
    }

    public UserProfile findById(Long id) {
        Optional<UserProfile> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id) );
    }

    public Optional<UserProfile> findByEmail(String email) {
        try{
            return repository.findByEmail(email);
        }catch(DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Optional<UserProfile> findByEmailAndPassword(String email, String password) {
        try{
            String decodedPssd = password.replace("kw*s.x$37tth@$u0K8lE9","").replace("0K2.lp$fzE6qj*tk5lp@$","").trim();
            return repository.findByEmailAndPassword(email,decodedPssd);
        }catch(DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public UserProfile insert(UserProfile profile) {
        profile.setLastLoginTime(Instant.now());
        return repository.save(profile);
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

    public UserProfile update(Long id, UserProfile profile) {
        try {
            UserProfile entity = repository.getById(id);
            entity.setName(profile.getName());
            return repository.save(entity);
        }catch(EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

}
