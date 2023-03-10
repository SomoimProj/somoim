package com.Oinzo.somoim.club.entity;

import com.Oinzo.somoim.common.entity.BaseEntity;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Club extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    private String description;

    private String imageUrl;

    @NotNull
    private String area;

    @NotNull
    private int memberLimit;

    @NotNull
    private int memberCnt;

    @NotNull
    private String favorite;

}
