package com.javamaster.repositoryTests;

import com.javamaster.entity.Races;
import com.javamaster.dao.GetHbRacesFromDB;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class GetRaceRepositoryTest {

    @Autowired
    private GetHbRacesFromDB getHbRacesFromDB;

    @Test
    void findAllRacesDB() {
        List<Races> races = getHbRacesFromDB.findAllRacesDB();
        races.forEach(it-> System.out.println(it));
        Assertions.assertEquals(1, 1);
    }

}
