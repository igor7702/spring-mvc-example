package com.javamaster.repositoryTests;

import com.javamaster.entity.Teams;
import com.javamaster.repository.TeamsCrudRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class TeamsCrudRepositoryTest {

    @Autowired
    private TeamsCrudRepository teamsCrudRepository;

    // Get
    @Test
    void findAllTeamsDB() {
        List<Teams> teams = teamsCrudRepository.findAllTeamsDB();
        teams.forEach(it-> System.out.println(it));
        Assertions.assertEquals(15, teams.size());
    }

    @Test
    void findWhereIdTeamParam() {
        List<Teams> teams = teamsCrudRepository.findWhereIdTeamParam(10L);
        teams.forEach(it-> System.out.println(it));
        Assertions.assertEquals(1, teams.size());
    }

    @Test
    void findWhereNameTeamParam() {
        List<Teams> teams = teamsCrudRepository.findWhereNameTeamParam("Mercedes");
        teams.forEach(it-> System.out.println(it));
        Assertions.assertEquals(1, teams.size());
    }

    // Create
    @Test
    void createTeamsAllParams() {
        teamsCrudRepository.createTeamNameParametr("Mclaren mercedes");
        Assertions.assertEquals(1, 1);
    }

    // Delete
    @Test
    void deleteWithAnswerWhereIdParametr() {
        List<Teams> teams = teamsCrudRepository.deleteWithAnswerWhereIdParametr(13L);
        teams.forEach(it-> System.out.println(it));
        int CountDeleted = teams.size();
        Assertions.assertEquals(1, CountDeleted);
    }

    // Update

}
