package com.javamaster.controller;

import com.javamaster.dao.SetHbRaceToDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddHbRaceInfoController {

    @Autowired
    private SetHbRaceToDB setHbRaceToDB;

    @GetMapping("/addHbRaceInfo")
    public String home(@RequestParam(required = false) String numberOfTheRaceWeek,
                       Model model, String yearOfTheRace, String countryOfTheRace,
                       String cityOfTheRace, String specialCode) {
        int idCountry = 0;
        int idCity = 0;
        String idRace = yearOfTheRace + numberOfTheRaceWeek;

        // Получить id страны
        // Получить id города
        // Если нет страны - создать новую страну, получить id страны
        // Если нет города - создать новый город, получить id города

        setHbRaceToDB.createRaceAllParams(numberOfTheRaceWeek, yearOfTheRace, countryOfTheRace,
                cityOfTheRace, idCountry, idCity, idRace);

        return "answerAddRaceInfo_page";
    }
}