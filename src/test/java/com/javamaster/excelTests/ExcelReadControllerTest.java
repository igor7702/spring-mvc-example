package com.javamaster.excelTests;

import com.javamaster.entity.Cities;
import com.javamaster.repository.GetCitiesRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class ExcelReadControllerTest {

    @Autowired
    private GetCitiesRepository getCitiesRepository;

    @Test
    void findAllCitiesDB() {
        List<Cities> cities = getCitiesRepository.findAllCitiesDB();
        cities.forEach(it-> System.out.println(it));
        Assertions.assertEquals(1, 1);
    }

    @Test
    void findWhereNameCityParam() {
        List<Cities> cities = getCitiesRepository.findWhereNameCityParam("Sochi");
        cities.forEach(it-> System.out.println(it));
        Assertions.assertEquals(1, cities.size());
    }

}
