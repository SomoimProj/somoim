package com.Oinzo.somoim.user.repository;

import com.Oinzo.somoim.user.entity.VerificationCode;
import com.Oinzo.somoim.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Transactional
@SpringBootTest
class VerificationCodeRepositoryTest {

    @Autowired
    VerificationCodeRepository verificationCodeRepository;
    @Autowired
    UserService userService;

    @Test
    void verificationCodeTest() {
        verificationCodeRepository.deleteAll();
        //given
        String verificationCode1 = userService.createVerificationCode();
        VerificationCode numberAndCode1 = new VerificationCode("01011111111", verificationCode1);

        String verificationCode2 = userService.createVerificationCode();

        VerificationCode numberAndCode2 = new VerificationCode("01022222222", verificationCode2);

        //when
        VerificationCode code1 = verificationCodeRepository.save(numberAndCode1);
        VerificationCode code2 = verificationCodeRepository.save(numberAndCode2);

        System.out.println("생성된 인증번호 : " + verificationCode1);
        System.out.println(code1.getPhoneNumber());
        System.out.println(code1.getVerificationCode());
        System.out.println("==============================");
        System.out.println("생성된 인증번호 : " + verificationCode2);
        System.out.println(code2.getPhoneNumber());
        System.out.println(code2.getVerificationCode());

        //then
        assertEquals(code1.getVerificationCode(), verificationCode1);
        assertEquals(code2.getVerificationCode(), verificationCode2);

    }
}