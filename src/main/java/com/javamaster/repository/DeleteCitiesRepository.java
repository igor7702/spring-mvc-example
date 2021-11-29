package com.javamaster.repository;

import com.javamaster.entity.Cities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DeleteCitiesRepository extends JpaRepository<Cities, Long> {

    void deleteById(Long idCity);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "delete from cities where name_city like :cityName")
    void deleteWhereCitNameParametr(String cityName);
}
