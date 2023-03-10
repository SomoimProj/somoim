package com.Oinzo.somoim.club.repository;

import com.Oinzo.somoim.club.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {

    List<Club> findAllByNameLike(String name);

    List<Club> findAllByFavoriteLikeAndAreaLike(String favorite,String area);
}
