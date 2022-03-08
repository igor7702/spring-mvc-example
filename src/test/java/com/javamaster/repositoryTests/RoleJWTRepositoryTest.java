package com.javamaster.repositoryTests;

import com.javamaster.entity.RoleEntity;
import com.javamaster.repository.RoleEntityRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class RoleJWTRepositoryTest {

    @Autowired
    private RoleEntityRepository roleEntityRepository;

    @Test
    void findByName() {
        RoleEntity roleEntity = roleEntityRepository.findByName("ROLE_ADMIN");
        System.out.println(roleEntity.getId() + "-" + roleEntity.getName());
        Assertions.assertEquals(1, 1);
    }

}
