package com.javamaster.repositoryTests;

import com.javamaster.entity.Pilots;
import com.javamaster.repository.PilotsCrudRepository;
import com.javamaster.repository.TeamsCrudRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class PilotsCrudRepositoryTest {

    @Autowired
    private TeamsCrudRepository teamsCrudRepository;
    @Autowired
    private PilotsCrudRepository pilotsCrudRepository;

    // Get
    @Test
    void findAllPilotsDB() {
        List<Pilots> pilots = pilotsCrudRepository.findAllPilotsDB();
        pilots.forEach(it-> System.out.println(it));
        Assertions.assertEquals(20, pilots.size());
    }

    @Test
    void findWhereIdTeamParam() {
        List<Pilots> pilots = pilotsCrudRepository.findWhereIdPilotParam(10L);
        pilots.forEach(it-> System.out.println(it));
        Assertions.assertEquals(1, pilots.size());
    }

    @Test
    void findWhereNameTeamParam() {
        List<Pilots> pilots = pilotsCrudRepository.findWhereNamePilotParam("Nicholas Latifi");
        pilots.forEach(it-> System.out.println(it));
        Assertions.assertEquals(1, pilots.size());
    }

    // Получить запись пилота по русскому имени
    @Test
    void findWhereNameRusParam() {
        List<Pilots> pilots = pilotsCrudRepository.findWhereNameRusParam("Макс Ферстаппен");
        pilots.forEach(it-> System.out.println(it));
        Assertions.assertEquals(1, pilots.size());
    }

    // Create
    @Test
    void createPilotNameParametr() {
        pilotsCrudRepository.createPilotNameParametr("Lewis Hamilton");
        Assertions.assertEquals(1, 1);
    }

    @Test
    void createTeam2Parametr() {
        pilotsCrudRepository.createPilotParametr("Lewis Hamilton", "Hamilton");
        Assertions.assertEquals(1, 1);
    }

    // Delete
    @Test
    void deleteVoidWhereIdParametr() {
        pilotsCrudRepository.deleteVoidWhereIdParametr(3L);
        Assertions.assertEquals(1, 1);
    }

    // Update
    @Test
    void updateWhereNameRusAndIdParam() {
        pilotsCrudRepository.updateWhereNameRusAndIdParam("Льюис Хэмилтон", 1L);
        Assertions.assertEquals(1, 1);
    }

}
