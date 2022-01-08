package com.javamaster.repository;

import com.javamaster.entity.Teams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TeamsCrudRepository extends JpaRepository<Teams, Long> {

    // Get
    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM teams", nativeQuery = true)
    List<Teams> findAllTeamsDB();

    @Transactional(readOnly = true)
    @Query(nativeQuery = true, value = "select * from teams where name_teams like %:nameTeam%")
    List<Teams> findWhereNameTeamParam(String nameTeam);

    @Transactional(readOnly = true)
    @Query(nativeQuery = true, value = "select * from teams where name_teams = :nameTeam and year_teams = :yearTeam")
    List<Teams> findWhereNameTeamAndYearParam(int yearTeam, String nameTeam);

    @Transactional(readOnly = true)
    @Query(nativeQuery = true, value = "select * from teams where id=:idTeam")
    List<Teams> findWhereIdTeamParam(Long idTeam);

    @Transactional(readOnly = true)
    @Query(nativeQuery = true, value = "select * from teams where name_teams = :nameTeam")
    List<Teams> findWhereNameTeamAndYearParam(String nameTeam);

    // Create
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "insert into teams (name_teams) values (:nameTeam)")
    void createTeamNameParametr(String nameTeam);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "insert into teams (name_teams, year_teams, code_teams) " +
            "values (:nameTeam, :yearTeam, :codeTeam)")
    void createTeam4Parametr(String nameTeam, int yearTeam, String codeTeam);

    // Delete
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "delete from teams where id=:id")
    void deleteVoidWhereIdParametr(long id);

    // Delete
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "delete from teams where id=:id")
    List<Teams> deleteWhereIdParametr(long id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "delete from teams where id=:id is true Returning *")
    List<Teams> deleteWithAnswerWhereIdParametr(long id);

    // Update
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update teams set name_teams=:nameTeam where id=:idTeam")
    void updateWhereIdAndNameTeamParam(String nameTeam, Long idTeam);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update teams set year_teams=:yearTeam, code_teams=:codeTeam where id=:idTeam")
    void updateWhereYearAndCodeTeamParam(int yearTeam, String codeTeam, Long idTeam);
}