package com.Oinzo.somoim.club.entity;

import com.Oinzo.somoim.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Club extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column
    private String imageUrl;

    @Column(nullable = false)
    private String area;

    @Column(nullable = false)
    private int memberLimit;

    @Column(nullable = false)
    private int memberCnt;

    @Column(nullable = false)
    private String favorite;
}
