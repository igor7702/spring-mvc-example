package com.javamaster.repositoryTests;

import com.javamaster.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class UsersRepositoryTest {

    @Autowired
    private UserService userService;

    @Test
    void findUsers() {
        userService.findAll().forEach(it-> System.out.println(it));
        userService.findAllByName("Smith").forEach(it-> System.out.println(it));
        userService.findWhereEmailIsGmail().forEach(it-> System.out.println(it));
        userService.findWhereNameStartsFromSmith().forEach(it-> System.out.println(it));
        Assertions.assertEquals(1, 1);
    }

}
