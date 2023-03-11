package com.oinzo.somoim.user.repository;

import com.oinzo.somoim.user.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Likes, Long> {
}
