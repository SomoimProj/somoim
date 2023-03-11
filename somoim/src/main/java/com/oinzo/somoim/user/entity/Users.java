package com.oinzo.somoim.user.entity;

import com.oinzo.somoim.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Users extends BaseEntity {

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

    @Column
    private String introduction;

    @Column(nullable = false)
    private String phoneNumber;

    @Column
    private String profileUrl;

    @Column
    private String favorite;
}
