package com.toy.springsecuritycore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Resources {

    @Id
    @GeneratedValue
    private Long id;

    private String httpMethod;

    private int orderNum;

    private String resourceName;

    private String resourceType;

}
