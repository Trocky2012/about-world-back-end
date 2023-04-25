package com.starengtech.aboutWorld.config;

import com.starengtech.aboutWorld.entities.Adverts;
import com.starengtech.aboutWorld.entities.AwUser;
import com.starengtech.aboutWorld.repositories.AdvertsRepository;
import com.starengtech.aboutWorld.repositories.AwUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class ConfigTest implements CommandLineRunner {

    @Autowired
    private AwUserRepository awUserRepository;

    @Autowired
    private AdvertsRepository advertsRepository;

    @Override
    public void run(String... args) throws Exception {

        AwUser u1 = new AwUser(null, "Thiago", "thiago@gmail.com", "123456","Brazilian", "Canada","Back-end", true);
        AwUser u2 = new AwUser(null, "Renan", "renan@gmail.com", "123456","Brazilian", "Ireland","Front-end", true);
        AwUser u3 = new AwUser(null, "Aline", "aline@gmail.com", "123456","Canadian", "Canada", "Engineering");
        AwUser u4 = new AwUser(null, "Kaiu", "kaiu@gmail.com", "123456","Irish", "Ireland", "Development");

        awUserRepository.saveAll(Arrays.asList(u1, u2, u3, u4));

        Adverts ad1 = new Adverts(null, "My Title", "My description", u1);
        Adverts ad2 = new Adverts(null, "My Title Renan", "My description Renan", u2);

        advertsRepository.saveAll(Arrays.asList(ad1, ad2));
    }
}
