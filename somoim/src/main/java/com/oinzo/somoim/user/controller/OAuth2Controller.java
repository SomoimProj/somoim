package com.oinzo.somoim.user.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.oinzo.somoim.user.dto.request.GoogleLoginRequest;
import com.oinzo.somoim.user.dto.request.KakaoLoginRequest;
import com.oinzo.somoim.user.service.OAuth2Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class OAuth2Controller {

	private final OAuth2Service oAuth2Service;

	@PostMapping("/oauth/kakao")
	public void kakaoLogin(@RequestBody KakaoLoginRequest request) throws JsonProcessingException {
		Long userId = oAuth2Service.kakaoLogin(request.getCode());
		// TODO: JWT 토큰 발급
	}

	@PostMapping("/oauth/google")
	public void googleLogin(@RequestBody GoogleLoginRequest request) throws JsonProcessingException {
		Long userId = oAuth2Service.googleLogin(request.getAccessToken());
		// TODO: JWT 토큰 발급
	}
}
