package com.javamaster.repository;

import com.javamaster.entity.Countries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DeleteCountriesRepository extends JpaRepository<Countries, Long> {

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "delete from countries where id=:id")
    List<Countries> deleteWhereIdParametr(long id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "delete from countries where id=:id is true Returning *")
    List<Countries> deleteWithAnswerWhereIdParametr(long id);

}
