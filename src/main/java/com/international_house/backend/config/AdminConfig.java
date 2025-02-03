package com.international_house.backend.config;

import com.international_house.backend.domain.Admin;
import com.international_house.backend.repos.AdminRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AdminConfig {


    @Bean
    CommandLineRunner commandLineRunner(AdminRepository repository) {

        return args -> {
            Admin makif = new Admin("akif","guel","123");
            repository.saveAll(List.of(makif));
        };

    }
}
