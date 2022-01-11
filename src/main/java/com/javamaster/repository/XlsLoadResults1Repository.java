package com.javamaster.repository;

import com.javamaster.entity.Teams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface XlsLoadResults1Repository extends JpaRepository<Teams, Long> {

    // Create
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "insert into XlsLoadResults1 (" +
            "position, " +
            "numberpilot, " +
            "namepilot, " +
            "team, " +
            "motor, " +
            "laps, " +
            "racetime, " +
            "lead, " +
            "gap, " +
            "pitstops, " +
            "crash, " +
            "points, " +
            "country" +
            ") " +
            "values (" +
            ":position, " +
            ":numberPilot, " +
            ":namePilot, " +
            ":team, " +
            ":motor, " +
            ":laps, " +
            ":raceTime, " +
            ":lead, " +
            ":gap, " +
            ":pitStops, " +
            ":crash, " +
            ":points, " +
            ":country" +
            ")"
    )

    void createAllParametr(
            double position,
            double numberPilot,
            String namePilot,
            String team,
            String motor,
            double laps,
            String raceTime,
            String lead,
            String gap,
            double pitStops,
            String crash,
            double points,
            double country
    );

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "insert into XlsLoadResults1 (" +
            "position, " +
            "numberpilot " +
            ") " +
            "values (" +
            ":position, " +
            ":numberPilot " +
            ")")

    void create2Parametr(
            double position,
            double numberPilot
    );

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "insert into XlsLoadResults1 (" +
            "position, " +
            "numberpilot, " +
            "namepilot" +
            ") " +
            "values (" +
            ":position, " +
            ":numberPilot, " +
            ":namePilot " +
            ")"
    )

    void create3Parametr(
            double position,
            double numberPilot,
            String namePilot
    );

    // Delete
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "delete from xlsLoadresults1")
    void deleteAllTable();

}