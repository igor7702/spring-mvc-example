package com.javamaster.repository;

import com.javamaster.entity.Results;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ResultsCrudRepository extends JpaRepository<Results, Long> {

    // Get
    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM results", nativeQuery = true)
    List<Results> findAllResultsDB();

    @Transactional(readOnly = true)
    @Query(nativeQuery = true, value = "select * from results where race_name like :raceName")
    List<Results> findWhereRaceNameParam(String raceName);

    @Transactional(readOnly = true)
    @Query(nativeQuery = true, value = "select * from results where race_name like :raceName and pilot_name like :pilotName")
    List<Results> findWhereRaceNameAndCodePilotParam(String raceName, String pilotName);

    @Transactional(readOnly = true)
    @Query(nativeQuery = true, value = "select * from results where id=:idResult")
    List<Results> findWhereIdResultParam(Long idResult);

    // Create
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "insert into results (" +
            "race_id," +
            "race_name," +
            "type_race_id," +
            "type_race_name," +
            "team_id," +
            "team_name," +
            "pilot_id" +
            "pilot_name" +
            "laps" +
            "bestlap" +
            "start_greed" +
            "end_greed" +
            "points_pilot" +
            "points_pilot_all" +
            "points_team" +
            "points_team_all" +
            ") " +
            "VALUES (" +
            ":raceId," +
            ":raceName," +
            ":typeRaceId," +
            ":typeRaceName," +
            ":teamId," +
            ":teamName," +
            ":lap" +
            ":bestlap" +
            ":startGreed" +
            ":endGreed" +
            ":pointsPilot" +
            ":pointsPilotAll" +
            ":pointsTeam" +
            ":pointsTeamAll" +
            ")"
    )
    void createResultsAllParams(int raceId,
                                String raceName,
                                int typeRaceId,
                                String typeRaceName,
                                int teamId,
                                String teamName,
                                int lap,
                                boolean bestlap,
                                int startGreed,
                                int endGreed,
                                int pointsPilot,
                                int pointsPilotAll,
                                int pointsTeam,
                                int pointsTeamAll
    );

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "insert into results (" +
            "race_id," +
            "race_name," +
            "pilot_id," +
            "pilot_name" +
            ") " +
            "VALUES (" +
            ":raceId," +
            ":raceName," +
            ":pilotId," +
            ":pilotName" +
            ")"
    )
    void createResultsNumberRaceCodePilotParams(
                                int raceId,
                                String raceName,
                                int pilotId,
                                String pilotName

    );

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "insert into results (" +
            "race_id," +
            "race_name" +
            ") " +
            "VALUES (" +
            ":raceId," +
            ":raceName" +
            ")"
    )
    void create2raceIdAndRaceNameParams(
            int raceId,
            String raceName
    );

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "insert into results (" +
            "race_name" +
            ") " +
            "VALUES (" +
            ":raceName" +
            ")"
    )
    void create1Params(
            String raceName
    );

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "insert into results (" +
            "race_id" +
            ") " +
            "VALUES (" +
            ":raceId" +
            ")"
    )
    void create1IdParams(
            int raceId
    );

    // Pilot
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "insert into results (" +
            "pilot_name" +
            ") " +
            "VALUES (" +
            ":pilotName" +
            ")"
    )
    void create1ParamsPilotName(
            String pilotName
    );

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "insert into results (" +
            "pilot_id," +
            "pilot_name" +
            ") " +
            "VALUES (" +
            ":pilotId," +
            ":pilotName" +
            ")"
    )
    void create2pilotIdAndPilotNameParams(
            int pilotId,
            String pilotName
    );

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "insert into results (" +
            "pilot_id," +
            "pilot_name," +
            "race_id," +
            "race_name " +
            ") " +
            "VALUES (" +
            ":pilotId," +
            ":pilotName, " +
            ":RaceId," +
            ":RaceName" +
            ")"
    )
    void create4_IdPilot_PilotName_IdRace_NameRaceParams(
            int pilotId,
            String pilotName,
            int RaceId,
            String RaceName
    );

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "insert into results (" +
            "type_race_id," +
            "type_race_namе" +
            ") " +
            "VALUES (" +
            ":typeRaceId," +
            ":typeRaceName" +
            ")"
    )
    void create2_typeRaceId_typeRaceName_Params(
            int typeRaceId,
            String typeRaceName
    );

    // Create bestlap
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "insert into results (" +
            "bestLap" +
            ") " +
            "VALUES (" +
            ":bestLap" +
            ")"
    )
    void create1_BestLap_Boolean_Params(
            boolean bestLap
    );

    // Create end_gread
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "insert into results (" +
            "end_grid" +
            ") " +
            "VALUES (" +
            ":endGrid" +
            ")"
    )
    void create1_EndGrid_Int_Params(
            int endGrid
    );

    // Update
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update results set " +
            "type_race_id=:idTypeRace, " +
            "type_race_namе=:NameTypeRace " +
            "where " +
            "race_id = :IdRace and " +
            "pilot_id = :IdPilot" +
            "")
    void UpdateResults_IdTapeRace_NameTypeRace_By_RaceAndPilots(int IdRace, int IdPilot,
                                                                int idTypeRace, String NameTypeRace);

    // Delete
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "delete from results")
    void deleteAllTable();

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "delete from results where id=:id")
    void deleteVoidWhereIdParametr(long id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "delete from results where id=:id")
    List<Results> deleteWhereIdParametr(long id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "delete from results where id=:id is true Returning *")
    List<Results> deleteWithAnswerWhereIdParametr(long id);

    // Update
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update results set laps=:laps where race_name=:raceName")
    void updateWhereRacIdParam(int laps, String raceName);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update results set laps=:laps, " +
            "bestlap=:bestlap where race_name=:raceName")
    void updateWhereNameAndCodeTeamParam(int lap, boolean bestlap, String raceName);
}