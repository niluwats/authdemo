package com.nw.authdemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class VerificationToken {
    @Id
    @SequenceGenerator(
            name = "verificationtoken_sequence",
            sequenceName = "verificationtoken_sequence"
    )
    @GeneratedValue(
            generator = "verificationtoken_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long id;
    private String token;
    private LocalDateTime createdAt;
    private LocalDateTime expireAt;
    private LocalDateTime verifiedAt;

    @OneToOne(targetEntity = User.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    private Date calculateExpiration(int expirationMinutes){
        Calendar cal=Calendar.getInstance();
        cal.setTime(new Timestamp(cal.getTime().getTime()));
        cal.add(Calendar.MINUTE,expirationMinutes);
        return new Date(cal.getTime().getTime());
    }
}
