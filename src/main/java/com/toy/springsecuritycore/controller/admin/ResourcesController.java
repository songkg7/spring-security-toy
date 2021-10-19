package com.toy.springsecuritycore.controller.admin;

import com.toy.springsecuritycore.domain.dto.ResourcesDto;
import com.toy.springsecuritycore.domain.entity.Resources;
import com.toy.springsecuritycore.domain.entity.Role;
import com.toy.springsecuritycore.repository.RoleRepository;
import com.toy.springsecuritycore.security.metadatasource.UrlFilterInvocationSecurityMetadataSource;
import com.toy.springsecuritycore.service.ResourcesService;
import com.toy.springsecuritycore.service.RoleService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/resources")
@RequiredArgsConstructor
public class ResourcesController {

    private final ResourcesService resourcesService;
    private final RoleRepository roleRepository;
    private final RoleService roleService;
    private final ModelMapper modelMapper;
    private final UrlFilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource;

    @GetMapping
    public String selectResources(Model model) {
        List<Resources> resources = resourcesService.selectResources();
        model.addAttribute("resources", resources);
        return "/admin/resource/list";
    }

    @PostMapping
    public String insertResources(ResourcesDto resourcesDto) {
        Role role = roleRepository.findByRoleName(resourcesDto.getRoleName());
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        Resources resources = modelMapper.map(resourcesDto, Resources.class);
        resources.setRoleSet(roles);

        resourcesService.insertResources(resources);
        filterInvocationSecurityMetadataSource.reload();
        return "redirect:/admin/resources";
    }

    @GetMapping("/register")
    public String viewRoles(Model model) {
        List<Role> roleList = roleService.getRoles();
        model.addAttribute("roleList", roleList);

        ResourcesDto resourcesDto = new ResourcesDto();
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(new Role());
        resourcesDto.setRoleSet(roleSet);
        model.addAttribute("resources", resourcesDto);

        return "/admin/resource/detail";
    }

    @GetMapping(value="/{id}")
    public String getResources(@PathVariable String id, Model model) {
        List<Role> roleList = roleService.getRoles();
        model.addAttribute("roleList", roleList);
        Resources resources = resourcesService.selectResources(Long.parseLong(id));

        ModelMapper modelMapper = new ModelMapper();
        ResourcesDto resourcesDto = modelMapper.map(resources, ResourcesDto.class);
        model.addAttribute("resources", resourcesDto);

        return "admin/resource/detail";
    }

    @GetMapping(value="/delete/{id}")
    public String removeResources(@PathVariable String id) {
        resourcesService.deleteResources(Long.parseLong(id));
        filterInvocationSecurityMetadataSource.reload();
        return "redirect:/admin/resources";
    }
}
