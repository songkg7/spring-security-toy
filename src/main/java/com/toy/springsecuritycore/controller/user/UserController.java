package com.toy.springsecuritycore.controller.user;

import com.toy.springsecuritycore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    @GetMapping("/mypage")
    public String myPage() {
        return "user/mypage";
    }

    @GetMapping("/users")
    public String createUser() {
        return "user/login/register";
    }

//    @PostMapping("/users")
//    public String createUser(AccountDto accountDto) {
//        Account account = modelMapper.map(accountDto, Account.class);
//        account = account.withPassword(passwordEncoder.encode(accountDto.getPassword()));
//        userService.createUser(account);
//        return "redirect:/";
//    }
}
