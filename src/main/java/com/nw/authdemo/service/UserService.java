package com.nw.authdemo.service;

import com.nw.authdemo.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    UserDto findUserByEmail(String email);
    UserDto findUser(Long id);
    List<UserDto> findAllUsers();
}
