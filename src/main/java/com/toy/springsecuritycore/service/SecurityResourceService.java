package com.toy.springsecuritycore.service;

import com.toy.springsecuritycore.domain.entity.AccessIp;
import com.toy.springsecuritycore.domain.entity.Resources;
import com.toy.springsecuritycore.repository.AccessIpRepository;
import com.toy.springsecuritycore.repository.ResourcesRepository;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@RequiredArgsConstructor
public class SecurityResourceService {

    private final ResourcesRepository resourcesRepository;
    private final AccessIpRepository accessIpRepository;

    public LinkedHashMap<RequestMatcher, List<ConfigAttribute>> getResourceList() {

        LinkedHashMap<RequestMatcher, List<ConfigAttribute>> result = new LinkedHashMap<>();
        List<Resources> resourceList = resourcesRepository.findAllResources();
        resourceList.forEach(resource -> {
            List<ConfigAttribute> configAttributeList = new ArrayList<>();
            resource.getRoleSet().forEach(role -> {
                configAttributeList.add(new SecurityConfig(role.getRoleName()));
                result.put(new AntPathRequestMatcher(resource.getResourceName()), configAttributeList);
            });
        });
        return result;
    }

    public List<String> getAccessIpList() {
        return accessIpRepository.findAll().stream()
                .map(AccessIp::getIpAddress)
                .collect(Collectors.toList());
    }

}
