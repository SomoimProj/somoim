package com.Oinzo.somoim.user.entity;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@RedisHash(value = "to", timeToLive = 180)
public class VerificationCode {

    @Id
    private String phoneNumber;

    @Indexed
    private String verificationCode;

    public VerificationCode(String phoneNumber, String verificationCode) {
        this.phoneNumber = phoneNumber;
        this.verificationCode = verificationCode;
    }
}
