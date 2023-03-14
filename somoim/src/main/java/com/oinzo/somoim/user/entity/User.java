package com.oinzo.somoim.user.entity;

import com.oinzo.somoim.common.entity.BaseEntity;
import com.oinzo.somoim.common.type.Gender;
import com.oinzo.somoim.common.type.Provider;
import com.oinzo.somoim.user.dto.KakaoUserInfoDto;
import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String birth;
    @Enumerated(value = EnumType.STRING)
    private Gender gender;
    private String area;
    private String introduction;
    private String profileUrl;
    private String favorite;

    @Enumerated(value = EnumType.STRING)
    private Provider provider;
    private String providerId;

    public static User from(KakaoUserInfoDto kakaoUserInfoDto) {
        return User.builder()
            .provider(Provider.KAKAO)
            .providerId(String.valueOf(kakaoUserInfoDto.getKakaoId()))
//            .birth(kakaoUserInfoDto.getBirthday())
            .gender(kakaoUserInfoDto.getGender())
            .profileUrl(kakaoUserInfoDto.getProfileUrl())
            .build();
    }
}
