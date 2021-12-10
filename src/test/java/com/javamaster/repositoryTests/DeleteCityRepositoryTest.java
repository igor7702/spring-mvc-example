package com.javamaster.repositoryTests;

import com.javamaster.entity.Cities;
import com.javamaster.repository.DeleteCitiesRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class DeleteCityRepositoryTest {

    @Autowired
    private DeleteCitiesRepository deleteCitiesRepository;

     @Test
    void deleteWithAnswerWhereIdParametr() {
        List<Cities> cities = deleteCitiesRepository.deleteWithAnswerWhereIdParametr(8L);
        cities.forEach(it-> System.out.println(it));
        int CountDeleted = cities.size();
        Assertions.assertEquals(1, CountDeleted);
    }

}
