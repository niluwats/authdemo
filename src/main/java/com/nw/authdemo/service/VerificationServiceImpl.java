package com.nw.authdemo.service;

import com.nw.authdemo.entity.VerificationToken;
import com.nw.authdemo.repository.VerificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@AllArgsConstructor
@Service
public class VerificationServiceImpl implements  VerificationService{
    private final VerificationRepository verificationRepository;

    @Override
    public void saveVerificationToken(VerificationToken token) {
        verificationRepository.save(token);
    }

    @Override
    public Optional<VerificationToken> getToken(String token) {
        return verificationRepository.findByToken(token);
    }

    @Override
    public int setVerifiedAt(String token) {
        return verificationRepository.updateVerifiedAt(token, LocalDateTime.now());
    }
}
