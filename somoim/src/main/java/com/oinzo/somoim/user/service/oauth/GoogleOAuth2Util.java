package com.oinzo.somoim.user.service.oauth;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oinzo.somoim.user.dto.GoogleUserInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Component
public class GoogleOAuth2Util {

	private final RestTemplate restTemplate;

	public GoogleUserInfoDto getUserInfo(String accessToken) throws JsonProcessingException {
		String userInfoBody = requestUserInfo(accessToken);
		return parseUserInfo(userInfoBody);
	}

	private String requestUserInfo(String accessToken) {
		String GOOGLE_USERINFO_REQUEST_URL = "https://www.googleapis.com/oauth2/v1/userinfo";

		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(headers);
		ResponseEntity<String> response = restTemplate.exchange(
			GOOGLE_USERINFO_REQUEST_URL,
			HttpMethod.GET,
			request,
			String.class
		);

		return response.getBody();
	}

	private GoogleUserInfoDto parseUserInfo(String responseBody) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(responseBody);

		String id = jsonNode.get("id").asText();

		String name = jsonNode.get("name").asText();
		String profileUrl = jsonNode.get("picture").asText();

		return GoogleUserInfoDto.builder()
			.googleId(id)
			.name(name)
			.profileUrl(profileUrl)
			.build();
	}
}
