package com.javamaster.repository;

import com.javamaster.entity.TypesRace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TypesRaceCrudRepository extends JpaRepository<TypesRace, Long> {

    // Get
    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM typesrace", nativeQuery = true)
    List<TypesRace> findAllTypesRaceDB();

    @Transactional(readOnly = true)
    @Query(nativeQuery = true, value = "select * from typesrace where name_typesrace like :nameTypeRace")
    List<TypesRace> findWhereNameTypeRaceParam(String nameTypeRace);

    @Transactional(readOnly = true)
    @Query(nativeQuery = true, value = "select * from typesrace where id=:idTypesRace")
    List<TypesRace> findWhereIdTypeRaceParam(Long idTypesRace);

    // Create
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "insert into typesrace (name_typesname) values (:nameTyperace)")
    void createTypeRaceNameParametr(String nameTyperace);

    // Delete
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "delete from teams where id=:id")
    void deleteVoidWhereIdParametr(long id);
//
//    // Delete
//    @Modifying
//    @Transactional
//    @Query(nativeQuery = true, value = "delete from teams where id=:id")
//    List<Teams> deleteWhereIdParametr(long id);
//
//    @Modifying
//    @Transactional
//    @Query(nativeQuery = true, value = "delete from teams where id=:id is true Returning *")
//    List<Teams> deleteWithAnswerWhereIdParametr(long id);
//
//    // Update
//    @Modifying
//    @Transactional
//    @Query(nativeQuery = true, value = "update teams set name_teams=:nameTeam where id=:idTeam")
//    void updateWhereIdAndNameTeamParam(String nameTeam, Long idTeam);
//
//    @Modifying
//    @Transactional
//    @Query(nativeQuery = true, value = "update teams set year_teams=:yearTeam, code_teams=:codeTeam where id=:idTeam")
//    void updateWhereYearAndCodeTeamParam(int yearTeam, String codeTeam, Long idTeam);
}