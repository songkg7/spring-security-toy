package com.toy.springsecuritycore.service.impl;

import com.toy.springsecuritycore.domain.entity.RoleHierarchy;
import com.toy.springsecuritycore.repository.RoleHierarchyRepository;
import com.toy.springsecuritycore.service.RoleHierarchyService;
import java.util.Iterator;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleHierarchyServiceImpl implements RoleHierarchyService {

    private final RoleHierarchyRepository roleHierarchyRepository;

    @Override
    public String findAllHierarchy() {

        List<RoleHierarchy> roleHierarchies = roleHierarchyRepository.findAll();

        Iterator<RoleHierarchy> iterator = roleHierarchies.iterator();
        StringBuilder concatRoles = new StringBuilder();
        while (iterator.hasNext()) {
            RoleHierarchy roleHierarchy = iterator.next();
            if (roleHierarchy.getParentName() != null) {
                concatRoles.append(roleHierarchy.getParentName().getChildName());
                concatRoles.append(" > ");
                concatRoles.append(roleHierarchy.getChildName());
                concatRoles.append("\n");
            }
        }
        return concatRoles.toString();
    }

}
