package com.toy.springsecuritycore.service;

import com.toy.springsecuritycore.domain.dto.AccountDto;
import com.toy.springsecuritycore.domain.entity.Account;
import java.util.List;

public interface UserService {

    void createUser(Account account);

    void modifyUser(AccountDto accountDto);

    List<Account> getUsers();

    AccountDto getUser(Long id);

    void deleteUser(Long id);

}
