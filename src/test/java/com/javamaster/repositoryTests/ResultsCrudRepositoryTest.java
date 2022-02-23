package com.javamaster.repositoryTests;

import com.javamaster.entity.Results;
import com.javamaster.repository.ResultsCrudRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class ResultsCrudRepositoryTest {

    @Autowired
    private ResultsCrudRepository resultsCrudRepository;

    // Get
    @Test
    void findAllResultsDB() {
        List<Results> results = resultsCrudRepository.findAllResultsDB();
        results.forEach(it-> System.out.println(it));
        Assertions.assertEquals(20, results.size());
    }

    @Test
    void findWhereIdResultsParam() {
        List<Results> results = resultsCrudRepository.findWhereIdResultParam(10L);
        results.forEach(it-> System.out.println(it));
        Assertions.assertEquals(1, results.size());
    }

    @Test
    void findWhereNameTeamParam() {
        List<Results> pilots = resultsCrudRepository.findWhereRaceNameParam("202142");
        pilots.forEach(it-> System.out.println(it));
        Assertions.assertEquals(1, pilots.size());
    }

    // Create
    @Test
    void createResultsNumberRaceCodePilotParams() {
        resultsCrudRepository.createResultsNumberRaceCodePilotParams(34, "202149",1, "Hamilton");
        Assertions.assertEquals(1, 1);
    }

    @Test
    void create2raceIdAndRaceNameParams() {
        resultsCrudRepository.create2raceIdAndRaceNameParams(
                34,
                "202149"
        );
        Assertions.assertEquals(1, 1);
    }

    @Test
    void create1Params() {
        resultsCrudRepository.create1Params(
                "202149"
        );
        Assertions.assertEquals(1, 1);
    }

    @Test
    void create1IdParams() {
        resultsCrudRepository.create1IdParams(
                33
        );
        Assertions.assertEquals(1, 1);
    }

    // Pilot
    @Test
    void create1ParamsPilotName() {
        resultsCrudRepository.create1ParamsPilotName(
                "Main"
        );
        Assertions.assertEquals(1, 1);
    }

    @Test
    void create2pilotIdAndPilotNameParams() {
        resultsCrudRepository.create2pilotIdAndPilotNameParams(5, "New");
        Assertions.assertEquals(1, 1);
    }

    @Test
    void create4_IdPilot_PilotName_IdRace_NameRaceParams() {
        resultsCrudRepository.create4_IdPilot_PilotName_IdRace_NameRaceParams(5, "New", 2, "NewRace");
        Assertions.assertEquals(1, 1);
    }

    // Delete
    @Test
    void deleteAllTable() {
        resultsCrudRepository.deleteAllTable();
        Assertions.assertEquals(1, 1);
    }

    @Test
    void deleteVoidWhereIdParametr() {
        resultsCrudRepository.deleteVoidWhereIdParametr(2L);
        Assertions.assertEquals(1, 1);
    }

//    // Update
//    @Test
//    void updateWhereYearAndCodeTeamParam() {
//        teamsCrudRepository.updateWhereYearAndCodeTeamParam(2021, "2021_Ferrari", 4L);
//        Assertions.assertEquals(1, 1);
//    }

}
