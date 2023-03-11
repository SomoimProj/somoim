package com.oinzo.somoim.user.repository;

import com.oinzo.somoim.user.entity.Recent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecentRepository extends JpaRepository<Recent, Long> {
}
