package com.javamaster.repository;

import com.javamaster.entity.Races;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GetRacesRepository extends JpaRepository<Races, Long> {

    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM races", nativeQuery = true)
    List<Races> findAllRacesDB();

    @Transactional(readOnly = true)
    @Query(nativeQuery = true, value = "select * from races where " +
            "week_race like :numberWeek and " +
            "year_race like :numberYear")
    List<Races> findWhereWeekYearParam(String numberWeek, String numberYear);

    @Transactional(readOnly = true)
    @Query(nativeQuery = true, value = "select * from races where id_race = :idRace")
    List<Races> findWhereIdRaceParam(String idRace);

    @Transactional(readOnly = true)
    @Query(nativeQuery = true, value = "select * from races where " +
            "id_race like :codeRace"
            )
    List<Races> findWhereCodeRaceParam(String codeRace);

}