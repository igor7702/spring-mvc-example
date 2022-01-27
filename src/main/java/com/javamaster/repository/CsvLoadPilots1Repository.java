package com.javamaster.repository;

import com.javamaster.entity.CsvLoadPilots1;
import com.javamaster.entity.Pilots;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CsvLoadPilots1Repository extends JpaRepository<CsvLoadPilots1, Long> {

    // Create
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "insert into csvloadpilots1 (" +
            "namepilotrus, " +
            "codepiloteng " +
            ") " +
            "values (" +
            ":namePilotRus, " +
            ":codePilotEng " +
            ")"
    )

    void createAllParametr(
            String namePilotRus,
            String codePilotEng
    );

    // Delete
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "delete from csvloadpilots1")
    void deleteAllTable();

    // Get
    @Transactional(readOnly = true)
    @Query(nativeQuery = true, value = "select * from csvloadpilots1 where codepiloteng = :codePilotEng")
    List<CsvLoadPilots1> findWhereCodePilotEng(String codePilotEng);

    // Update
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update csvloadpilots1 set codepiloteng=:codePilotEng where id=:idPilot")
    void updateCodePilotByIdParam(String codePilotEng, int idPilot);

}