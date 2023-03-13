package com.oinzo.somoim;

import com.oinzo.somoim.user.entity.Users;
import com.oinzo.somoim.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Transactional
@SpringBootTest
public class UsersRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void insertUser() {
        //given
        Users newUser = new Users(1l, "hong", "2023-03-06",
                "남", "광진구", null, "01012345678",
                null, null);

        //when
        userRepository.save(newUser);

        //then
        List<Users> usersList = userRepository.findAll();
        assertTrue(usersList.size() > 0);
    }

}
