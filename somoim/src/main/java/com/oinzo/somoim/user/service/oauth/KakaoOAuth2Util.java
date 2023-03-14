package com.oinzo.somoim.user.service.oauth;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oinzo.somoim.user.dto.KakaoUserInfoDto;
import com.oinzo.somoim.common.type.Gender;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Component
public class KakaoOAuth2Util {

	@Value("${oauth2.kakao.client-id}")
	private String KAKAO_CLIENT_ID;

	private final RestTemplate restTemplate;

	public String getAccessToken(String code) throws JsonProcessingException {
		String accessTokenBody = requestAccessToken(code);
		return parseAccessToken(accessTokenBody);
	}

	public KakaoUserInfoDto getUserInfo(String accessToken) throws JsonProcessingException {
		String userInfoBody = requestUserInfo(accessToken);
		return parseUserInfo(userInfoBody);
	}
	
	private String requestAccessToken(String code) {
		String KAKAO_ACCESS_TOKEN_REQUEST_URL = "https://kauth.kakao.com/oauth/token";
		// TODO: 배포된 프론트 리다이렉트 주소로 변경 필요
		String KAKAO_CODE_REDIRECT_URL = "http://localhost:8080/user/oauth/kakao";	// 인가코드 받았던 리다이렉트 주소

		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded;charset=utf-8");

		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("grant_type", "authorization_code");
		body.add("client_id", KAKAO_CLIENT_ID);
		body.add("redirect_uri", KAKAO_CODE_REDIRECT_URL);
		body.add("code", code);

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, headers);
		ResponseEntity<String> response = restTemplate.exchange(
			KAKAO_ACCESS_TOKEN_REQUEST_URL,
			HttpMethod.POST,
			request,
			String.class
		);

		return response.getBody();
	}

	private String parseAccessToken(String responseBody) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(responseBody);
		return jsonNode.get("access_token").asText();
	}

	private String requestUserInfo(String accessToken) {
		String KAKAO_USERINFO_REQUEST_URL = "https://kapi.kakao.com/v2/user/me";

		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);
		headers.add(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded;charset=utf-8");

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(headers);
		ResponseEntity<String> response = restTemplate.exchange(
			KAKAO_USERINFO_REQUEST_URL,
			HttpMethod.POST,
			request,
			String.class
		);

		return response.getBody();
	}

	private KakaoUserInfoDto parseUserInfo(String responseBody) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(responseBody);

		long id = jsonNode.get("id").asLong();

		JsonNode kakaoAccountNode = jsonNode.get("kakao_account");
		String profileUrl = kakaoAccountNode.get("profile").get("profile_image_url").asText();
		String gender = kakaoAccountNode.get("gender").asText();
		String birthday = kakaoAccountNode.get("birthday").asText();

		return KakaoUserInfoDto.builder()
			.kakaoId(id)
			.profileUrl(profileUrl)
			.gender(gender.equals("male") ? Gender.MALE : Gender.FEMALE)	// Gender enum으로 변경
			.birthday(birthday)
			.build();
	}

}
