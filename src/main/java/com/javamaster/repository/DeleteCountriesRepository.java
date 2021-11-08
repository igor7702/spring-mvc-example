package com.javamaster.repository;

import com.javamaster.entity.Countries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeleteCountriesRepository extends JpaRepository<Countries, Long> {

    @Query(value = "delete * from country where code_country like '%643%'", nativeQuery = true)
    List<Countries> deleteWhereCodeCountryIs643();
}
