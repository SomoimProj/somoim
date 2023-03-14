package com.oinzo.somoim.user.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.oinzo.somoim.user.service.OAuth2Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class OAuth2Controller {

	private final OAuth2Service oAuth2Service;

	@GetMapping("/oauth/kakao")
	public void kakaoLogin(@RequestParam String code) throws JsonProcessingException {
		Long userId = oAuth2Service.kakaoLogin(code);
		// TODO: JWT 토큰 발급
	}
}
