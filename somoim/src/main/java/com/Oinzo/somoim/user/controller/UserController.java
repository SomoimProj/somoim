package com.Oinzo.somoim.user.controller;

import com.Oinzo.somoim.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users")
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    /**
     * 인증번호 발송
     */
    @PostMapping("/send-one")
    public ResponseEntity<?> sendSms(@RequestParam(value = "to") String to) {

        String sms = userService.sendSms(to);

        return ResponseEntity.ok(sms);
    }

    /**
     * 인증번호 확인
     */
    @PostMapping("/check-sms")
    public ResponseEntity<?> checkSms(@RequestParam String code) {

        String verificationCode = userService.checkSms(code);

        return ResponseEntity.ok(verificationCode);
    }
}
