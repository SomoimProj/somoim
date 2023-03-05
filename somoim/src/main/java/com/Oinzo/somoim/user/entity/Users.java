package com.Oinzo.somoim.user.entity;

import com.Oinzo.somoim.common.entity.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Users extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String birth;

    @Column
    private String gender;

    @Column
    private String area;

    @Column
    private String introduction;

    @Column
    private String phoneNumber;

    @Column
    private String profileUrl;

    @Column
    private String favorite;
}
