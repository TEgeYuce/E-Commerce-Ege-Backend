package com.example.workintech.ecommege.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

import com.example.workintech.ecommege.repository.RoleRepository;
import com.example.workintech.ecommege.entity.Role;

@Configuration
@RequiredArgsConstructor
public class SeedDataConfig {

    private final RoleRepository roleRepository;

    @Bean
    CommandLineRunner seedRoles() {
        return args -> {

            if (roleRepository.count() == 0) {

                Role customer = new Role();
                customer.setName("Customer");
                customer.setCode("ROLE_CUSTOMER");

                Role admin = new Role();
                admin.setName("Admin");
                admin.setCode("ROLE_ADMIN");

                Role store = new Role();
                store.setName("Store");
                store.setCode("ROLE_STORE");

                roleRepository.save(customer);
                roleRepository.save(admin);
                roleRepository.save(store);

                System.out.println("Default roles created!");
            }
        };
    }
}