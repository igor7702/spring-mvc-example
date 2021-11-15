package com.javamaster.repository;

import com.javamaster.entity.Countries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DeleteCountriesRepository extends JpaRepository<Countries, Long> {

    @Query(value = "delete from country where code_country like '%643%'", nativeQuery = true)
    List<Countries> deleteWhereCodeCountryIs643();

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "delete from countries where code_country like :codeCountry")
    void deleteWhereCodeCountryParametr(String codeCountry);
}
