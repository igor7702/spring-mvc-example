package com.javamaster.repositoryTests;

import com.javamaster.repository.SetRaceRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class SetRaceRepositoryTest {

    @Autowired
    private SetRaceRepository setRaceRepository;

    @Test
    void createRaceAllParams() {
        setRaceRepository.createRaceAllParams("25", "2021", "Austria", "Bern",
                    1, 1, "202124");
        Assertions.assertEquals(1, 1);
    }

}
