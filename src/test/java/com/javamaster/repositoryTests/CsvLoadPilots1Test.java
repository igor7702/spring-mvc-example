package com.javamaster.repositoryTests;

import com.javamaster.repository.CsvLoadPilots1Repository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class CsvLoadPilots1Test {

    @Autowired
    private CsvLoadPilots1Repository csvLoadPilots1Repository;

    // Create
    @Test
    void createAllParametr() {
        csvLoadPilots1Repository.createAllParametr(
                "Люис Хэмильтон",
                "Hamilton"
        );
        Assertions.assertEquals(1, 1);
    }

     // Update
    @Test
    void updateAllParametr() {
        csvLoadPilots1Repository.updateCodePilotByIdParam(
                "Russell",
                15
        );
        Assertions.assertEquals(1, 1);
    }

    // Delete
    @Test
    void ClearTableXlsLoadResults1() {
        csvLoadPilots1Repository.deleteAllTable();
        Assertions.assertEquals(1, 1);
    }
}

