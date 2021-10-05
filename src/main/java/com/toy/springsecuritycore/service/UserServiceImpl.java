package com.toy.springsecuritycore.service;

import com.toy.springsecuritycore.domain.Account;
import com.toy.springsecuritycore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Transactional
    @Override
    public void createUser(Account account) {

        userRepository.save(account);

    }

}
