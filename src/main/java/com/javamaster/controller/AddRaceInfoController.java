package com.javamaster.controller;

import com.javamaster.dao.GetRaceFromDB;
import com.javamaster.dao.SetRaceToDB;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddRaceInfoController {

    @GetMapping("/addRaceInfo")
    public String home(@RequestParam(required = false) String numberOfTheRaceWeek,
                       Model model, String yearOfTheRace, String countryOfTheRace,
                       String cityOfTheRace, String specialCode) {

        SetRaceToDB raceToDBObj;
        raceToDBObj = new SetRaceToDB(numberOfTheRaceWeek, yearOfTheRace, countryOfTheRace,
                cityOfTheRace, specialCode);

        return "answerAddRaceInfo_page";
    }
}