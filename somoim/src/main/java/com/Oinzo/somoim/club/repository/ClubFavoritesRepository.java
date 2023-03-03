package com.Oinzo.somoim.club.repository;

import com.Oinzo.somoim.club.entity.ClubFavorites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubFavoritesRepository extends JpaRepository<ClubFavorites, Long> {
}
