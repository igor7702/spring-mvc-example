package com.javamaster.repository;

import com.javamaster.entity.Countries;
import com.javamaster.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GetCountriesRepository extends JpaRepository<Countries, Long> {

    @Transactional(readOnly = true)
    @Query(nativeQuery = true, value = "select * from countries where code_country like :codeCountry")
    List<Countries> findWhereCodeCountryParam(String codeCountry);

    @Transactional(readOnly = true)
    @Query(nativeQuery = true, value = "select * from countries where name_country like :nameCountry")
    List<Countries> findWhereNameCountryParam(String nameCountry);

    @Transactional(readOnly = true)
    @Query(nativeQuery = true, value = "select * from countries")
    List<Countries> findAllCountries();
}
