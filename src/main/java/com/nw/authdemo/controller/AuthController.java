package com.nw.authdemo.controller;

import com.nw.authdemo.dto.LoginRequestDto;
import com.nw.authdemo.dto.LoginResponseDto;
import com.nw.authdemo.dto.RegisterDto;
import com.nw.authdemo.dto.UserDto;
import com.nw.authdemo.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    private final AuthenticationService authService;
    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody RegisterDto registerDto){
        return ResponseEntity.ok(authService.saveUser(registerDto));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto>login(@RequestBody LoginRequestDto loginRequestDto){
        return ResponseEntity.ok(authService.authenticate(loginRequestDto));
    }

    @GetMapping("/verifyEmail")
    public ResponseEntity<String> verifyEmail(@RequestParam("token") String token){
        return ResponseEntity.ok(authService.verifyToken(token));
    }
}
