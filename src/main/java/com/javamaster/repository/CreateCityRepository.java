package com.javamaster.repository;

import com.javamaster.entity.Cities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CreateCityRepository extends JpaRepository<Cities, Long> {

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "insert into cities (city_name) values (:nameCity)")
    void createCityNameParametr(String nameCity);
}