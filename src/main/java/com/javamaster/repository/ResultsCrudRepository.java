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
    void createResultsAllParams(String weekRace, String yearRace,
                             String nameCountry, String nameCity,
                             long idCountry, long idCity, String idRace);

    // Delete
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