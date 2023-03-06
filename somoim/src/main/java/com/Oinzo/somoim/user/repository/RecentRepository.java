package com.Oinzo.somoim.user.repository;

import com.Oinzo.somoim.user.entity.Recent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecentRepository extends JpaRepository<Recent, Long> {
}
