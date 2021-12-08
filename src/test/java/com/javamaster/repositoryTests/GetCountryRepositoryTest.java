package com.javamaster.repositoryTests;

import com.javamaster.entity.Cities;
import com.javamaster.entity.Countries;
import com.javamaster.repository.GetCountriesRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class GetCountryRepositoryTest {

    @Autowired
    private GetCountriesRepository getCountriesRepository;

    @Test
    void findWhereCodeCountryParam() {
       Countries countries = getCountriesRepository.findWhereCodeCountryParam("643").get(0);
       String nameCountry=countries.getName_country();
       System.out.println(nameCountry);
       Assertions.assertEquals(1, 1);
    }

    @Test
    void findAllCountries() {
        List<Countries> countries = getCountriesRepository.findAllCountries();
        countries.forEach(it-> System.out.println(it));
        Assertions.assertEquals(4, countries.size());
    }

    @Test
    void findWhereNameCountryParam() {
        List<Countries> countries = getCountriesRepository.findWhereNameCountryParam("Russia");
        countries.forEach(it-> System.out.println(it));
        System.out.println("size = " + countries.size());
        Assertions.assertEquals(1, countries.size());
    }

}
