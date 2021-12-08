package com.javamaster.repositoryTests;

import com.javamaster.entity.Countries;
import com.javamaster.repository.DeleteCountriesRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class DeleteCountryRepositoryTest {

    @Autowired
    private DeleteCountriesRepository deleteCountriesRepository;

    @Test
    void deleteCountryById() {
        List<Countries> countries = deleteCountriesRepository.deleteWithAnswerWhereIdParametr(5L);
        countries.forEach(it-> System.out.println(it));
        int CountDeleted = countries.size();
        Assertions.assertEquals(1, CountDeleted);
    }

}
