package com.javamaster.repository;

import com.javamaster.entity.Pilots;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PilotsCrudRepository extends JpaRepository<Pilots, Long> {

    // Get
    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM pilots", nativeQuery = true)
    List<Pilots> findAllPilotsDB();

    @Transactional(readOnly = true)
    @Query(nativeQuery = true, value = "select * from pilots where name_pilots like :namePilot")
    List<Pilots> findWhereNamePilotParam(String namePilot);

    @Transactional(readOnly = true)
    @Query(nativeQuery = true, value = "select * from pilots where id=:idPilot")
    List<Pilots> findWhereIdPilotParam(Long idPilot);

    @Transactional(readOnly = true)
    @Query(nativeQuery = true, value = "select * from pilots where namerus is null")
    List<Pilots> findWhereNameRusNull();

    // Получить запись пилота по русскому имени
    @Transactional(readOnly = true)
    @Query(nativeQuery = true, value = "select * from pilots where namerus like :nameRus")
    List<Pilots> findWhereNameRusParam(String nameRus);

    // Create
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "insert into pilots (name_pilots) values (:namePilot)")
    void createPilotNameParametr(String namePilot);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "insert into pilots (name_pilots, code_pilots) " +
            "values (:namePilot, :codePilot)")
    void createPilotParametr(String namePilot, String codePilot);

    // Delete
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "delete from pilots where id=:id")
    void deleteVoidWhereIdParametr(long id);
//
//    @Modifying
//    @Transactional
//    @Query(nativeQuery = true, value = "delete from pilots where id=:id")
//    List<Pilots> deleteWhereIdParametr(long id);
//
//    @Modifying
//    @Transactional
//    @Query(nativeQuery = true, value = "delete from pilots where id=:id is true Returning *")
//    List<Pilots> deleteWithAnswerWhereIdParametr(long id);

    // Update
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update pilots set namerus=:nameRus where id=:idPilot")
    void updateWhereNameRusAndIdParam(String nameRus, Long idPilot);

//    @Modifying
//    @Transactional
//    @Query(nativeQuery = true, value = "update pilots set name_pilots=:namePilot, " +
//            "code_pilots=:codePilots where id=:idPilot")
//    void updateWhereNameAndCodeTeamParam(String namePilot, String codePilot, Long idPilot);
}