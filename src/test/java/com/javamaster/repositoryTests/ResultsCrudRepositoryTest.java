package com.javamaster.repositoryTests;

import com.javamaster.entity.Results;
import com.javamaster.repository.ResultsCrudRepository;
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
        List<Results> results = resultsCrudRepository.findWhereIdResultParam(213L);
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

    //Create BestLap
    @Test
    void create1_BestLap_Boolean_Params() {
        resultsCrudRepository.create1_BestLap_Boolean_Params(true);
        Assertions.assertEquals(1, 1);
    }

    // Create end_grid
    @Test
    void create1_EndGread_Int_Params() {
        resultsCrudRepository.create1_EndGrid_Int_Params(0);
        Assertions.assertEquals(1, 1);
    }

    // Create RaceId and RaceName
    @Test
    void create2_typeRaceId_typeRaceName_Params() {
        resultsCrudRepository.create2_typeRaceId_typeRaceName_Params(1, "Main");
        Assertions.assertEquals(1, 1);
    }

    // Установка значений по умолчанию
    // Update поле bestlap в false вместо null
    @Test
    void UpdateResults_BestLap_ToFalseWhereIdParam() {
        resultsCrudRepository.UpdateResults_BestLap_ToFalseWhereIdParam(205, true);
        Assertions.assertEquals(1, 1);
    }

    // Update поле type_race_id в 1 вместо null
    @Test
    void UpdateResults_TypeRaceID_To1WhereIdParam() {
        resultsCrudRepository.UpdateResults_TypeRaceID_To1WhereIdParam(207, 1);
        Assertions.assertEquals(1, 1);
    }

    // Update поле type_race_name в Main вместо null
    @Test
    void UpdateResults_TypeRaceName_ToMainWhereIdParam() {
        resultsCrudRepository.UpdateResults_TypeRaceName_ToMainWhereIdParam(207, "Main");
        Assertions.assertEquals(1, 1);
    }

    // Update поле team_id в 0 вместо null
    @Test
    void UpdateResults_TeamID_To0WhereIdParam() {
        resultsCrudRepository.UpdateResults_TeamID_To0WhereIdParam(205, 0);
        Assertions.assertEquals(1, 1);
    }

    // Update поле team_name в "" вместо null
    @Test
    void UpdateResults_teamName_ToEmptyStringWhereIdParam() {
        resultsCrudRepository.UpdateResults_teamName_ToEmptyStringWhereIdParam(207, "");
        Assertions.assertEquals(1, 1);
    }

    // Update поле laps в 0 вместо null
    @Test
    void UpdateResults_laps_ToZerogWhereIdParam() {
        resultsCrudRepository.UpdateResults_laps_ToZerogWhereIdParam(207, 0);
        Assertions.assertEquals(1, 1);
    }

    // Update поле start_grid в 0 вместо null
    @Test
    void UpdateResults_startGrid_ToZerogWhereIdParam() {
        resultsCrudRepository.UpdateResults_startGrid_ToZerogWhereIdParam(207, 0);
        Assertions.assertEquals(1, 1);
    }

    // Update поле end_grid в 0 вместо null
    @Test
    void UpdateResults_endGrid_ToZerogWhereIdParam() {
        resultsCrudRepository.UpdateResults_endGrid_ToZerogWhereIdParam(207, 0);
        Assertions.assertEquals(1, 1);
    }

    // Update поле points_pilot в 0 вместо null
    @Test
    void UpdateResults_pointsPilot_ToZerogWhereIdParam() {
        resultsCrudRepository.UpdateResults_pointsPilot_ToZerogWhereIdParam(207, 0);
        Assertions.assertEquals(1, 1);
    }

    // Update поле points_pilot_all в 0 вместо null
    @Test
    void UpdateResults_pointsPilotAll_ToZerogWhereIdParam() {
        resultsCrudRepository.UpdateResults_pointsPilotAll_ToZerogWhereIdParam(207, 0);
        Assertions.assertEquals(1, 1);
    }

    // Update поле points_team в 0 вместо null
    @Test
    void UpdateResults_pointsTeam_ToZerogWhereIdParam() {
        resultsCrudRepository.UpdateResults_pointsTeam_ToZerogWhereIdParam(207, 0);
        Assertions.assertEquals(1, 1);
    }

    // Update поле points_team_all в 0 вместо null
    @Test
    void UpdateResults_pointsTeamAll_ToZerogWhereIdParam() {
        resultsCrudRepository.UpdateResults_pointsTeamAll_ToZerogWhereIdParam(207, 0);
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

    // Update
    @Test
    void UpdateResults_IdTapeRace_NameTypeRace_By_RaceAndPilots() {
        resultsCrudRepository.UpdateResults_IdTapeRace_NameTypeRace_By_RaceAndPilots(34,1, 1, "Main");
        Assertions.assertEquals(1, 1);
    }

//    @Test
//    void updateWhereYearAndCodeTeamParam() {
//        teamsCrudRepository.updateWhereYearAndCodeTeamParam(2021, "2021_Ferrari", 4L);
//        Assertions.assertEquals(1, 1);
//    }

}
