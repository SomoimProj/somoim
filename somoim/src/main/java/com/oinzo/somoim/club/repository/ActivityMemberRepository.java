package com.oinzo.somoim.club.repository;

import com.oinzo.somoim.club.entity.ActivityMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityMemberRepository extends JpaRepository<ActivityMember, Long> {
}
