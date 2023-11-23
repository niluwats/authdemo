package com.nw.authdemo.service;

import com.nw.authdemo.dto.LoginRequestDto;
import com.nw.authdemo.dto.LoginResponseDto;
import com.nw.authdemo.dto.RegisterDto;
import com.nw.authdemo.dto.UserDto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface AuthenticationService {
    UserDto saveUser(RegisterDto userDto);
    LoginResponseDto authenticate(LoginRequestDto loginRequestDto);

    public String verifyToken(String token);

}
