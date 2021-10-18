package com.toy.springsecuritycore.repository;

import com.toy.springsecuritycore.domain.entity.Account;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByUsername(String username);

    int countByUsername(String username);

}
