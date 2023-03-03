package com.Oinzo.somoim.club.repository;

import com.Oinzo.somoim.club.entity.ClubMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubMemberRepository extends JpaRepository<ClubMember, Long> {
}
