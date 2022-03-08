package com.javamaster.repositoryTests;

import com.javamaster.entity.UserEntity;
import com.javamaster.repository.UserEntityRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class UserJWTRepositoryTest {

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Test
    void findByLogin() {
        UserEntity userEntity = userEntityRepository.findByLogin("user1");
        System.out.println(userEntity.getLogin() + " " + userEntity.getPassword() + " " + userEntity.getRoleEntity());
        Assertions.assertEquals(1, 1);
    }

}
