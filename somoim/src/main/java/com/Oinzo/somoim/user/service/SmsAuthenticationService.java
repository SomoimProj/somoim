package com.Oinzo.somoim.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Random;

@Slf4j
@Transactional
@RequiredArgsConstructor
@Service
public class SmsAuthenticationService {

    @Value("${external.api.key}")
    private String apiKey;

    @Value("${external.api.secret}")
    private String apiSecret;

    @Value("${external.api.fromNumber}")
    private String fromNumber;

    Message coolsms = new Message(apiKey, apiSecret);

    /**
     * 인증번호 생성
     */
    public String createRandomNumber() {
        Random random = new Random();
        String randomNumber = "";

        for (int i = 0; i < 6; i++) {
            randomNumber += Integer.toString(random.nextInt(10));
        }

        return randomNumber;
    }

    /**
     * 인증번호 메시지 전송
     */
    public String sendSms(String to) {

        HashMap<String, String> params = new HashMap<>();
        String randomNumber = createRandomNumber();

        params.put("to", to);
        params.put("from", fromNumber);
        params.put("type", "SMS");
        params.put("text", "[소모임] 인증번호는 " + randomNumber + " 입니다.");

        try {
            JSONObject obj = coolsms.send(params);
            System.out.println(obj.toString());
        } catch (CoolsmsException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCode());
        }

        return randomNumber;
    }
}
