package com.javamaster.repository;

import com.javamaster.entity.Countries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CountriesRepository extends JpaRepository<Countries, Long> {

    //List<Countries> findfindAllByName(String name);//просто правильное название метода даст возможность
    ////избежать запросов на SQL

//    @Query("select u from Countries u where u.code_country like '%643%'")//или написать
//        //собственный запрос на языке похожем на SQL
//    List<Countries> findWhereCodeContryIs643();

    @Query(value = "select * from users where name like '%Russia%'", nativeQuery = true)
        //или - можно написать запрос на чистом SQL
    List<Countries> findWhereNameCountryIsRussia();

    //    @Query(value = "delete * from country where code_country like '%643%'", nativeQuery = true)
//    List<Countries> deleteWhereCodeCountryIs643();

    // Create
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "insert into countries (name_country) values (:nameCountry)")
    void createCountryNameParametr(String nameCountry);
}
