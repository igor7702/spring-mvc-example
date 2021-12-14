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
    @Query(nativeQuery = true, value = "select * from teams where name_teams like :nameTeam")
    List<Teams> findWhereNameTeamParam(String nameTeam);

    @Transactional(readOnly = true)
    @Query(nativeQuery = true, value = "select * from teams where id=:idTeam")
    List<Teams> findWhereIdTeamParam(Long idTeam);

    // Create
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "insert into teams (name_teams) values (:nameTeam)")
    void createTeamNameParametr(String nameTeam);

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

}