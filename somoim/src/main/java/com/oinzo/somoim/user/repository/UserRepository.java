package com.oinzo.somoim.user.repository;

import com.oinzo.somoim.common.type.Provider;
import com.oinzo.somoim.user.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByProviderAndProviderId(Provider provider, String providerId);

}
