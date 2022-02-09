package com.javamaster.repository;

import com.javamaster.entity.XlsLoadResults1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface XlsLoadResults1Repository extends JpaRepository<XlsLoadResults1, Long> {

    // Get
    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM XlsLoadResults1", nativeQuery = true)
    List<XlsLoadResults1> findAllXlsLoadResults1DB();

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
            "position" +
            ") " +
            "values (" +
            ":position" +
            ")")

    void create1Parametr(
            int position
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
            int position,
            int numberPilot
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

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "insert into XlsLoadResults1 (" +
            "position, " +
            "numberpilot, " +
            "namepilot, " +
            "team" +
            ") " +
            "values (" +
            ":position, " +
            ":numberPilot, " +
            ":namePilot, " +
            ":team " +
            ")"
    )

    void create4Parametr(
            int position,
            int numberPilot,
            String namePilot,
            String team
    );

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "insert into XlsLoadResults1 (" +
            "position, " +
            "numberpilot, " +
            "namepilot, " +
            "team, " +
            "motor " +
            ") " +
            "values (" +
            ":position, " +
            ":numberPilot, " +
            ":namePilot, " +
            ":team, " +
            ":motor" +
            ")"
    )

    void create5Parametr(
            int position,
            int numberPilot,
            String namePilot,
            String team,
            String motor
    );

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "insert into XlsLoadResults1 (" +
            "position, " +
            "numberpilot, " +
            "namepilot, " +
            "team, " +
            "motor, " +
            "laps " +
            ") " +
            "values (" +
            ":position, " +
            ":numberPilot, " +
            ":namePilot, " +
            ":team, " +
            ":motor, " +
            ":laps" +
            ")"
    )

    void create6Parametr(
            int position,
            int numberPilot,
            String namePilot,
            String team,
            String motor,
            int laps
    );

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "insert into XlsLoadResults1 (" +
            "position, " +
            "numberpilot, " +
            "namepilot, " +
            "team, " +
            "motor, " +
            "laps, " +
            "racetime" +
            ") " +
            "values (" +
            ":position, " +
            ":numberPilot, " +
            ":namePilot, " +
            ":team, " +
            ":motor, " +
            ":laps, " +
            ":raceTime " +
            ")"
    )

    void create7Parametr(
            int position,
            int numberPilot,
            String namePilot,
            String team,
            String motor,
            int laps,
            String raceTime
    );

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
            "lead" +
            ") " +
            "values (" +
            ":position, " +
            ":numberPilot, " +
            ":namePilot, " +
            ":team, " +
            ":motor, " +
            ":laps, " +
            ":raceTime, " +
            ":lead " +
            ")"
    )

    void create8Parametr(
            int position,
            int numberPilot,
            String namePilot,
            String team,
            String motor,
            int laps,
            String raceTime,
            String lead
    );

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
            "gap" +
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
            ":gap" +
            ")"
    )

    void create9Parametr(
            int position,
            int numberPilot,
            String namePilot,
            String team,
            String motor,
            int laps,
            String raceTime,
            String lead,
            String gap
    );

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
            "pitstops" +
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
            ":pitStops" +
            ")"
    )

    void create10Parametr(
            int position,
            int numberPilot,
            String namePilot,
            String team,
            String motor,
            int laps,
            String raceTime,
            String lead,
            String gap,
            int pitStops
    );

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
            "crash" +
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
            ":crash" +
            ")"
    )

    void create11Parametr(
            int position,
            int numberPilot,
            String namePilot,
            String team,
            String motor,
            int laps,
            String raceTime,
            String lead,
            String gap,
            int pitStops,
            String crash
    );

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
            "points" +
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
            ":points" +
            ")"
    )

    void create12Parametr(
            int position,
            int numberPilot,
            String namePilot,
            String team,
            String motor,
            int laps,
            String raceTime,
            String lead,
            String gap,
            int pitStops,
            String crash,
            int points
    );

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

    void create13Parametr(
            int position,
            int numberPilot,
            String namePilot,
            String team,
            String motor,
            int laps,
            String raceTime,
            String lead,
            String gap,
            int pitStops,
            String crash,
            int points,
            int country
    );

    // Delete
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "delete from xlsLoadresults1")
    void deleteAllTable();

}