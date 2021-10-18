package com.toy.springsecuritycore.service;

import com.toy.springsecuritycore.domain.entity.Resources;
import java.util.List;

public interface ResourcesService {

    Resources selectResources(long id);

    List<Resources> selectResources();

    void insertResources(Resources resources);

    void deleteResources(long id);

}
