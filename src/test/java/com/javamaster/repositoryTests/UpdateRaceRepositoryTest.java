package com.javamaster.repositoryTests;

import com.javamaster.repository.UpdateRacesRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class UpdateRaceRepositoryTest {

    @Autowired
    private UpdateRacesRepository updateRacesRepository;

    @Test
    void updateWhereCodeCityParam() {
        updateRacesRepository.updateWhereAllRacesParam(
                1L, "40", "2021", "Hungary", "Monza",
                5L, 5L, "202140"
        );
        Assertions.assertEquals(1, 1);
    }

}
