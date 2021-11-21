package com.javamaster.repositoryTests;

import com.javamaster.entity.Countries;
import com.javamaster.repository.GetCountriesRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class CountryRepositoryTests {

@Autowired
private GetCountriesRepository getCountriesDao;

    @Test
    void t1() {
        List<Countries> countries = getCountriesDao.findWhereCodeCountryParam("643");
        Assertions.assertEquals(1,countries.size());
    }
}