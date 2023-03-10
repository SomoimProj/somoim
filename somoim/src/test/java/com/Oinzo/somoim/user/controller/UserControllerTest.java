package com.Oinzo.somoim.user.controller;

import com.Oinzo.somoim.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserControllerTest {

    @Autowired
    UserService userService;

    @Test
    void verificationCodeCheck() {
        //given
        String to = "01055555555";
        String verificationCode = userService.sendSms(to);

        //when
        String checkSms = userService.checkSms(verificationCode);

        //then
        assertEquals("OK", checkSms);
    }

}