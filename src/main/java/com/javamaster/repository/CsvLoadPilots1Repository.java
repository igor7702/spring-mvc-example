package com.javamaster.repository;

import com.javamaster.entity.CsvLoadPilots1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

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

}