package com.nw.authdemo.service;


import com.nw.authdemo.entity.VerificationToken;

import java.util.Optional;

public interface VerificationService {
    public void saveVerificationToken(VerificationToken token);

    Optional<VerificationToken> getToken(String token);

    public int setVerifiedAt(String token);
}
