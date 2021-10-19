package com.toy.springsecuritycore.config;

import com.toy.springsecuritycore.repository.ResourcesRepository;
import com.toy.springsecuritycore.service.SecurityResourceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public SecurityResourceService securityResourceService(ResourcesRepository resourcesRepository) {
        return new SecurityResourceService(resourcesRepository);
    }

}
