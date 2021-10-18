package com.toy.springsecuritycore.domain.dto;

import java.util.List;
import lombok.Data;

@Data
public class AccountDto {

    private String id;
    private String username;
    private String password;
    private String email;
    private int age;
    private List<String> roles;
}
