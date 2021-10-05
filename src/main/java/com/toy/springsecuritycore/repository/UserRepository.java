package com.toy.springsecuritycore.repository;

import com.toy.springsecuritycore.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Account, Long> {

    Account findByUsername(String username);

}
