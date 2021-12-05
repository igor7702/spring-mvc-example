package com.javamaster.repositoryTests;

import com.javamaster.entity.Cities;
import com.javamaster.entity.Races;
import com.javamaster.repository.DeleteRacesRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class DeleteRaceRepositoryTest {

    @Autowired
    private DeleteRacesRepository deleteRacesRepository;

    @Test
    void deleteRacesById() {
        deleteRacesRepository.deleteWhereIdParametr(6L);
        Assertions.assertEquals(1, 1);
    }

    @Test
    void deleteWithAnswerWhereIdParametr() {
        List<Races> races = deleteRacesRepository.deleteWithAnswerWhereIdParametr(3L);
        races.forEach(it-> System.out.println(it));
        int CountDeleted = races.size();
        Assertions.assertEquals(1, CountDeleted);
    }

    @Test
    void deleteRacesHbById() {
        deleteRacesRepository.deleteById(5L);
        Assertions.assertEquals(1, 1);
    }

}
