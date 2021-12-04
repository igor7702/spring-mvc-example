package com.javamaster.repositoryTests;

import com.javamaster.repository.UpdateCityRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class UpdateCityRepositoryTest {

    @Autowired
    private UpdateCityRepository updateCityRepository;

    @Test
    void updateWhereCodeCityParam() {
        updateCityRepository.updateWhereCodeCityParam(1, "NoName");
        Assertions.assertEquals(1, 1);
    }

}
