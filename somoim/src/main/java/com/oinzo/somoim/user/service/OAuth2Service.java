package com.oinzo.somoim.user.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.oinzo.somoim.user.dto.KakaoUserInfoDto;
import com.oinzo.somoim.common.type.Provider;
import com.oinzo.somoim.user.entity.User;
import com.oinzo.somoim.user.repository.UserRepository;
import com.oinzo.somoim.user.service.oauth.KakaoOAuth2Util;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OAuth2Service {

	private final UserRepository userRepository;
	private final KakaoOAuth2Util kakaoOAuth2Util;

	@Transactional
	public Long kakaoLogin(String code) throws JsonProcessingException {
		String accessToken = kakaoOAuth2Util.getAccessToken(code);
		KakaoUserInfoDto kakaoUserInfo = kakaoOAuth2Util.getUserInfo(accessToken);

		long kakaoId = kakaoUserInfo.getKakaoId();
		Optional<User> userOpt = userRepository.findByProviderAndProviderId(
			Provider.KAKAO,
			String.valueOf(kakaoId)
		);

		User user;
		if (userOpt.isEmpty()) {	// 카카오 정보로 등록된 사용자가 없다면 회원 등록
			User newUser = User.from(kakaoUserInfo);
			user = userRepository.save(newUser);
		} else {
			user = userOpt.get();
		}

		return user.getId();
	}
}
