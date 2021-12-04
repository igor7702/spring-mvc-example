package com.javamaster.repositoryTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import com.javamaster.repository.AccountRepository;
import com.javamaster.repository.UserRepository;
import com.javamaster.model.User;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {
    @Autowired
    private AccountRepository dao;
    @Autowired
    private UserRepository userDao;

    @Test
    void t1() {
        List<User> users = userDao.findByName("John");
        //   List<User> users=userDao.getByName("John");
        //  List<User> users=userDao.queryByName("John");
        // List<User> users = userDao.readByName("John");
        //   List<User> users=userDao.findAllByName("John");
        //   List<User> users=userDao.findUsersByName("John");
        //  List<User> users=userDao.findUserByName("John");
        Assertions.assertEquals(2, users.size());
    }


}
