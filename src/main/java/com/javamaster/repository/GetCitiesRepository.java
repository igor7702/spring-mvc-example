package com.javamaster.repository;

import com.javamaster.entity.Cities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GetCitiesRepository extends JpaRepository<Cities, Long> {

    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM cities", nativeQuery = true)
    List<Cities> findAllCitiesDB();

    @Transactional(readOnly = true)
    @Query(nativeQuery = true, value = "select * from cities where city_name like :nameCity")
    List<Cities> findWhereNameCityParam(String nameCity);
}