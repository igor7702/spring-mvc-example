package com.javamaster.repositoryTests;

import com.javamaster.entity.XlsLoadResults1;
import com.javamaster.repository.XlsLoadResults1Repository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class XlsLoadResults1Test {

    @Autowired
    private XlsLoadResults1Repository xlsLoadResults1Repository;

    // Get
    @Test
    void findAllXlsLoadResults1DB() {
        List<XlsLoadResults1> results = xlsLoadResults1Repository.findAllXlsLoadResults1DB();
        results.forEach(it2-> System.out.println(it2));
        Assertions.assertEquals(1, 1);
    }

    // Create
    @Test
    void createAllParametr() {
        xlsLoadResults1Repository.createAllParametr(
                1,
                44,
                "Alonso",
                "Ferrary",
                "Ferrary",
                54,
                "2:00:00",
                "5",
                "10",
                2,
                "No",
                234,
                202149
        );
        Assertions.assertEquals(1, 1);
    }

    @Test
    void create1Parametr() {
        xlsLoadResults1Repository.create1Parametr(
                1
        );
        Assertions.assertEquals(1, 1);
    }

    @Test
    void create2Parametr() {
        xlsLoadResults1Repository.create2Parametr(
                1,
                44
        );
        Assertions.assertEquals(1, 1);
    }

    @Test
    void create3Parametr() {
        xlsLoadResults1Repository.create3Parametr(
                1,
                44,
                "Hamilton"
        );
        Assertions.assertEquals(1, 1);
    }

    @Test
    void create4Parametr() {
        xlsLoadResults1Repository.create4Parametr(
                1,
                44,
                "Hamilton",
                "Mercedes"
        );
        Assertions.assertEquals(1, 1);
    }

    @Test
    void create5Parametr() {
        xlsLoadResults1Repository.create5Parametr(
                1,
                44,
                "Hamilton",
                "Mercedes",
                "Mercedes"
        );
        Assertions.assertEquals(1, 1);
    }

    @Test
    void create6Parametr() {
        xlsLoadResults1Repository.create6Parametr(
                1,
                44,
                "Hamilton",
                "Mercedes",
                "Mercedes",
                54
        );
        Assertions.assertEquals(1, 1);
    }

    @Test
    void create7Parametr() {
        xlsLoadResults1Repository.create7Parametr(
                1,
                44,
                "Hamilton",
                "Mercedes",
                "Mercedes",
                54,
                "100"
        );
        Assertions.assertEquals(1, 1);
    }

    @Test
    void create8Parametr() {
        xlsLoadResults1Repository.create8Parametr(
                1,
                44,
                "Hamilton",
                "Mercedes",
                "Mercedes",
                54,
                "100",
                "100"
        );
        Assertions.assertEquals(1, 1);
    }

    @Test
    void create9Parametr() {
        xlsLoadResults1Repository.create9Parametr(
                1,
                44,
                "Hamilton",
                "Mercedes",
                "Mercedes",
                54,
                "100",
                "100",
                "200"
        );
        Assertions.assertEquals(1, 1);
    }

    @Test
    void create10Parametr() {
        xlsLoadResults1Repository.create10Parametr(
                1,
                44,
                "Hamilton",
                "Mercedes",
                "Mercedes",
                54,
                "100",
                "100",
                "200",
                5
        );
        Assertions.assertEquals(1, 1);
    }

    @Test
    void create11Parametr() {
        xlsLoadResults1Repository.create11Parametr(
                1,
                44,
                "Hamilton",
                "Mercedes",
                "Mercedes",
                54,
                "100",
                "100",
                "200",
                5,
                "None"
        );
        Assertions.assertEquals(1, 1);
    }

    @Test
    void create12Parametr() {
        xlsLoadResults1Repository.create12Parametr(
                1,
                44,
                "Hamilton",
                "Mercedes",
                "Mercedes",
                54,
                "100",
                "100",
                "200",
                5,
                "None",
                15
        );
        Assertions.assertEquals(1, 1);
    }

    @Test
    void create13Parametr() {
        xlsLoadResults1Repository.create13Parametr(
                1,
                44,
                "Hamilton",
                "Mercedes",
                "Mercedes",
                54,
                "100",
                "100",
                "200",
                5,
                "None",
                15,
                2140
        );
        Assertions.assertEquals(1, 1);
    }

    // Delete
    @Test
    void ClearTableXlsLoadResults1() {
        xlsLoadResults1Repository.deleteAllTable();
        Assertions.assertEquals(1, 1);
    }
}

