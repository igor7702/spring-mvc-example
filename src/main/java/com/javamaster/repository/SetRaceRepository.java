package com.javamaster.repository;

import com.javamaster.entity.Races;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface SetRaceRepository extends JpaRepository<Races, Long> {

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "insert into races (" +
            "week_race," +
            "year_race," +
            "country_name_race," +
            "city_name_race," +
            "country_id_race," +
            "city_id_race," +
            "id_race) VALUES (" +
            ":weekRace," +
            ":yearRace," +
            ":nameCountry," +
            ":nameCity," +
            ":idCountry," +
            ":idCity," +
            ":idRace)"
    )
    void createRaceAllParams(String weekRace, String yearRace,
                              String nameCountry,String nameCity,
                              int idCountry, int idCity, String idRace);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "insert into races (" +
            "week_race," +
            "year_race," +
            "country_name_race," +
            "city_name_race," +
            "country_id_race," +
            "city_id_race," +
            "id_race) VALUES (" +
            ":weekRace," +
            ":yearRace," +
            ":nameCountry," +
            ":nameCity," +
            ":idCountry," +
            ":idCity," +
            ":idRace)"
    )
    List<Races> createRaceWithAnsweAllParams(String weekRace, String yearRace,
                             String nameCountry,String nameCity,
                             int idCountry, int idCity, String idRace);
}