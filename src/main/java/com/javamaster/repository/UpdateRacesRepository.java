package com.javamaster.repository;

import com.javamaster.entity.Races;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UpdateRacesRepository extends JpaRepository<Races, Long> {

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update races set " +
            "week_race=:weekRace " +
            "year_race=:yearRace " +
            "country_name_race=:nameCountry " +
            "city_name_race=:nameCity " +
            "country_id_race=:idCountry " +
            "city_id_race=:idCity " +
            "id_race=:idRace " +
            "where id=:id")
    void updateWhereAllRacesParam(Long id,
                                  String weekRace,
                                  String yearRace,
                                  String nameCountry,
                                  String nameCity,
                                  Long idCountry,
                                  Long idCity,
                                  String idRace
                                  );

}