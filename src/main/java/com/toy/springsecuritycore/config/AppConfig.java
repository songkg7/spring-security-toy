package com.toy.springsecuritycore.config;

import com.toy.springsecuritycore.repository.AccessIpRepository;
import com.toy.springsecuritycore.repository.ResourcesRepository;
import com.toy.springsecuritycore.service.SecurityResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AppConfig {

    private final AccessIpRepository accessIpRepository;
    private final ResourcesRepository resourcesRepository;

    @Bean
    public SecurityResourceService securityResourceService() {
        return new SecurityResourceService(resourcesRepository, accessIpRepository);
    }

}
