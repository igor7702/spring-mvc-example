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

}