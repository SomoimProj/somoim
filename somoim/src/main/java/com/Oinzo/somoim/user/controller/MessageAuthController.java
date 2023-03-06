package com.Oinzo.somoim.user.controller;

import com.Oinzo.somoim.user.service.SmsAuthenticationService;
import lombok.RequiredArgsConstructor;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users")
@RequiredArgsConstructor
@RestController
public class MessageAuthController {

    private final SmsAuthenticationService messageService;

    @PostMapping("/send-one")
    public ResponseEntity<?> sendSms(@RequestParam(value = "to") String to) throws CoolsmsException {

        String sms = messageService.sendSms(to);

        return ResponseEntity.ok(sms);
    }
}
