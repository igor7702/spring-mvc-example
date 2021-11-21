package com.javamaster.repository;

import com.javamaster.entity.Countries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UpdateCountriesRepository extends JpaRepository<Countries, Long> {

    @Transactional(readOnly = true)
    @Query(nativeQuery = true, value = "update countries set name_country=:nameCountry, where code_country like :codeCountry")
    void updateWhereCodeCountryParam(String codeCountry, String nameCountry);

}
