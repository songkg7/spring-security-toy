package com.toy.springsecuritycore.domain;

import lombok.Data;

@Data
public class AccountDto {
    private String username;
    private String password;
    private String email;
    private int age;
    private String role;
}
