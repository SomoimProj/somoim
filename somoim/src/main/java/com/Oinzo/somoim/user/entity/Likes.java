package com.Oinzo.somoim.user.entity;

import com.Oinzo.somoim.common.entity.BaseEntity;

import javax.persistence.*;

@Entity
public class Likes extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long userId;

    @Column
    private Long clubId;
}
