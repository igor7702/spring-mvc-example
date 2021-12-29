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
    @Query(nativeQuery = true, value = "insert into typesrace (nametypesrace) values (:nameTypeRace)")
    void createTypeRaceNameParametr(String nameTypeRace);

    // Delete
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "delete from typesrace where id=:id")
    void deleteVoidWhereIdParametr(long id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "delete from typesrace where id=:id is true Returning *")
    List<TypesRace> deleteWithAnswerWhereIdParametr(long id);

    // Update
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update typesrace set name_typesrace=:nameTypeRace where id=:idTypeRace")
    void updateWhereIdAndNameTypeRaceParam(String nameTypeRace, Long idTypeRace);

}