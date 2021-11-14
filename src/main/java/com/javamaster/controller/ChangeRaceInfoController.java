package com.javamaster.controller;

import com.javamaster.dao.ChangeRaceToDB;
import com.javamaster.dao.SetRaceToDB;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChangeRaceInfoController {

    @GetMapping("/changeRaceInfo")
    public String home(@RequestParam(required = false) String numberOfTheRaceWeek,
                       Model model, String yearOfTheRace, String countryOfTheRace,
                       String cityOfTheRace, String specialCode) {

        ChangeRaceToDB raceToDBObj;
        raceToDBObj = new ChangeRaceToDB(numberOfTheRaceWeek, yearOfTheRace, countryOfTheRace,
                cityOfTheRace, specialCode);

        return "answerChangeRaceInfo_page";
    }
}