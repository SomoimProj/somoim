package com.Oinzo.somoim.user.service;

import com.Oinzo.somoim.user.entity.VerificationCode;
import com.Oinzo.somoim.user.repository.UserRepository;
import com.Oinzo.somoim.user.repository.VerificationCodeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Optional;
import java.util.Random;

@Slf4j
@Transactional
@RequiredArgsConstructor
@Service
public class UserService {

    @Value("${external.api.key}")
    private String apiKey;

    @Value("${external.api.secret}")
    private String apiSecret;

    @Value("${external.api.from}")
    private String from;

    private final UserRepository userRepository;
    private final VerificationCodeRepository verificationCodeRepository;

    /**
     * 인증번호 생성
     */
    public String createVerificationCode() {
        Random random = new Random();
        String verificationCode = "";

        for (int i = 0; i < 6; i++) {
            verificationCode += Integer.toString(random.nextInt(10));
        }

        return verificationCode;
    }

    /**
     * 인증번호 메시지 발송
     */
    public String sendSms(String to) {
        Message coolsms = new Message(apiKey, apiSecret);

        HashMap<String, String> params = new HashMap<>();
        String verificationCode = createVerificationCode();

        params.put("to", to);
        params.put("from", from);
        params.put("type", "SMS");
        params.put("text", "소모임 인증번호는 [" + verificationCode + "] 입니다.");

        try {
            JSONObject obj = coolsms.send(params);
            System.out.println(obj.toString());
        } catch (CoolsmsException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCode());
        }

        verificationCodeRepository.save(new VerificationCode(to, verificationCode));
        log.info(to + "/" + verificationCode);
        return verificationCode;
    }

    /**
     * 인증번호 확인
     */
    public String checkSms(String code) {

        boolean result = verificationCodeRepository.findByVerificationCode(code).isPresent();
        System.out.println("전송받은 인증번호 --> " + code);

        if (result) {
            return "OK";
        }

        return "FAIL";
    }
}