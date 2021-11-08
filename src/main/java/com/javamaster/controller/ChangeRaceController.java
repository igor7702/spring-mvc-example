package com.javamaster.controller;

import com.javamaster.dao.GetRaceFromDB;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChangeRaceController {

    @GetMapping("/changeRace")
    public String home(@RequestParam(required = false) String numberOfTheRaceWeek,
                       Model model, String dataOfTheRace, String codeToChangeTheRaceInDB) {

        String countryRace;
        String cityrace="";

        GetRaceFromDB raceFromDBObj;
               raceFromDBObj = new GetRaceFromDB(numberOfTheRaceWeek, dataOfTheRace);

               countryRace = raceFromDBObj.getCountryRace();
               cityrace = raceFromDBObj.getCityRace();

               System.out.println("Country of the race is : " + countryRace);
               System.out.println("Week number of the race is: " + numberOfTheRaceWeek);
               System.out.println("Year of the race is: " + dataOfTheRace);
//                model.addAttribute("countryRace", countryRace);
//                model.addAttribute("numberOfTheRaceWeek", numberOfTheRaceWeek);
//                model.addAttribute("dataOfTheRace", dataOfTheRace);

                model.addAttribute("numberOfTheRaceWeek", numberOfTheRaceWeek);
                model.addAttribute("dataOfTheRace", dataOfTheRace);
                model.addAttribute("codeToChangeTheRaceInDB", codeToChangeTheRaceInDB);
        return "changeRace_page";
    }
}
