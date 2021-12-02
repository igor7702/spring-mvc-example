package com.javamaster.repositoryTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import com.javamaster.dao.AccountRepository;
import com.javamaster.dao.UserRepository;
import com.javamaster.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@DataJpaTest
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
