package com.javamaster.controller;

import com.javamaster.dao.DeleteRaceFromDB;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeleteRaceController {

    @GetMapping("/deleteRace")
    public String home(@RequestParam(required = false) String numberOfTheRaceWeek,
                       Model model, String yearOfTheRace, String codeToDeleteTheRaceFromDB
                       ) {

        DeleteRaceFromDB raceFromDBObj;
        raceFromDBObj = new DeleteRaceFromDB(numberOfTheRaceWeek, yearOfTheRace, codeToDeleteTheRaceFromDB);

        return "answerAddRaceInfo_page";
    }
}