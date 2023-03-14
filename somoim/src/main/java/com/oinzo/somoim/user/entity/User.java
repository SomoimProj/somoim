package com.oinzo.somoim.user.entity;

import com.oinzo.somoim.common.entity.BaseEntity;
import com.oinzo.somoim.common.type.Gender;
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
}
