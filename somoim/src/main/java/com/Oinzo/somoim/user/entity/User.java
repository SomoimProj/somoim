package com.Oinzo.somoim.user.entity;

import com.Oinzo.somoim.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String birth;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String area;

    @Column(nullable = false)
    private String phoneNumber;

    @Column
    private String introduction;

    @Column
    private String profileUrl;

    @Column
    private String favorite;

    public User(String name, String birth, String gender, String area) {
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.area = area;
    }

    public User(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}