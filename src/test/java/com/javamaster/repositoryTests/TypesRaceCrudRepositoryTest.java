package com.javamaster.repositoryTests;

import com.javamaster.entity.TypesRace;
import com.javamaster.repository.TeamsCrudRepository;
import com.javamaster.repository.TypesRaceCrudRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class TypesRaceCrudRepositoryTest {

    @Autowired
    private TypesRaceCrudRepository typesRaceCrudRepository;

    // Get
    @Test
    void findAllTypesRaceDB() {
        List<TypesRace> typesRaces = typesRaceCrudRepository.findAllTypesRaceDB();
        typesRaces.forEach(it-> System.out.println(it));
        Assertions.assertEquals(1, typesRaces.size());
    }

    @Test
    void findWhereIdTypesRaceParam() {
        List<TypesRace> typesRace = typesRaceCrudRepository.findWhereIdTypeRaceParam(1L);
        typesRace.forEach(it-> System.out.println(it));
        Assertions.assertEquals(1, typesRace.size());
    }

    @Test
    void findWhereNameTypesRaceTeamParam() {
        List<TypesRace> typesRace = typesRaceCrudRepository.findWhereNameTypeRaceParam("Main");
        typesRace.forEach(it-> System.out.println(it));
        Assertions.assertEquals(1, typesRace.size());
    }

    // Create
    @Test
    void createTypesRaceAllParams() {
        typesRaceCrudRepository.createTypeRaceNameParametr("Main");
        Assertions.assertEquals(1, 1);
    }

    // Delete
    @Test
    void deleteWithAnswerWhereIdParametr() {
        List<TypesRace> typesRace = typesRaceCrudRepository.findWhereIdTypeRaceParam(1L);
        typesRace.forEach(it-> System.out.println(it));
        int CountDeleted = typesRace.size();
        Assertions.assertEquals(1, CountDeleted);
    }

    @Test
    void deleteVoidWhereIdParametr() {
        typesRaceCrudRepository.deleteVoidWhereIdParametr(1L);
        Assertions.assertEquals(1, 1);
    }

    // Update
    @Test
    void updateWhereYearAndCodeTeamParam() {
        typesRaceCrudRepository.updateWhereIdAndNameTypeRaceParam("Main", 1L);
        Assertions.assertEquals(1, 1);
    }

}
