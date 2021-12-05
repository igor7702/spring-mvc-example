package com.javamaster.repository;

import com.javamaster.entity.Races;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DeleteRacesRepository extends JpaRepository<Races, Long> {

    void deleteById(Long id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "delete from races where id=:id")
    void deleteWhereIdParametr(long id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "delete from races where id=:id is true Returning *")
    List<Races> deleteWithAnswerWhereIdParametr(long id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "delete from races where idRace like :idRace")
    void deleteWhereRaceIdParametr(String idRace);

}
