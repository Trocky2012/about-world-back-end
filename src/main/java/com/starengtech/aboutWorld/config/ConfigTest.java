package com.starengtech.aboutWorld.config;

import com.starengtech.aboutWorld.entities.UserProfile;
import com.starengtech.aboutWorld.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class ConfigTest implements CommandLineRunner {

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public void run(String... args) throws Exception {

        UserProfile u1 = new UserProfile(null, "Thiago", "thiago@gmail.com", "123456", "Canada");
        UserProfile u2 = new UserProfile(null, "Renan", "renan@gmail.com", "123456", "Ireland");

        profileRepository.saveAll(Arrays.asList(u1, u2));
    }
}
