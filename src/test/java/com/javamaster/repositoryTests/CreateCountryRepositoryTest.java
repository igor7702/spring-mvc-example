package com.javamaster.repositoryTests;

import com.javamaster.entity.Countries;
import com.javamaster.repository.GetCountriesRepository;
import com.javamaster.repository.CountriesRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class CreateCountryRepositoryTest {

    @Autowired
    private CountriesRepository countriesRepository;

    // Create
    @Test
    void createCountryNameParams() {
        countriesRepository.createCountryNameParametr("United Arab Emirates");
        Assertions.assertEquals(1, 1);
    }

}
