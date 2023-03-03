package com.Oinzo.somoim.club.repository;

import com.Oinzo.somoim.club.entity.ActivityMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityMemberRepository extends JpaRepository<ActivityMember, Long> {
}
