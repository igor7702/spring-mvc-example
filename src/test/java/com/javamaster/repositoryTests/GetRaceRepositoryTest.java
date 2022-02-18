package com.javamaster.repositoryTests;

import com.javamaster.entity.Races;
import com.javamaster.dao.GetHbRacesFromDB;
import com.javamaster.repository.GetRacesRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class GetRaceRepositoryTest {

    @Autowired
    private GetHbRacesFromDB getHbRacesFromDB;

    @Autowired
    private GetRacesRepository getRacesRepository;

    @Test
    void findAllRacesDB() {
        List<Races> races = getRacesRepository.findWhereWeekYearParam("49", "2021");
        races.forEach(it-> System.out.println(it));
        Assertions.assertEquals(1, 1);
    }

    @Test
    void findRacesWithIdRaceDB() {
        List<Races> races = getRacesRepository.findWhereIdRaceParam("202112");
        races.forEach(it -> System.out.println(it));
        Assertions.assertEquals(1, 1);
    }

}
