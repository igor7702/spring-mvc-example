package com.javamaster.repository;

import com.javamaster.entity.Cities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UpdateCityRepository extends JpaRepository<Cities, Long> {

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update cities set city_name=:nameCity where id=:codeCity")
    void updateWhereCodeCityParam(int codeCity, String nameCity);
}
