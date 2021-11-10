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
                       Model model, String yearOfTheRace, String codeToChangeTheRaceInDB) {

        String countryOfTheRace;
        String cityOfTheRace;

        GetRaceFromDB raceFromDBObj;
               raceFromDBObj = new GetRaceFromDB(numberOfTheRaceWeek, yearOfTheRace);

               countryOfTheRace = raceFromDBObj.getCountryRace();
               cityOfTheRace = raceFromDBObj.getCityRace();

               System.out.println("Week number of the race is: " + numberOfTheRaceWeek);
               System.out.println("Year of the race is: " + yearOfTheRace);
               System.out.println("Country of the race is: " + countryOfTheRace);
               System.out.println("City of the race is: " + cityOfTheRace);

                model.addAttribute("numberOfTheRaceWeek", numberOfTheRaceWeek);
                model.addAttribute("dataOfTheRace", yearOfTheRace);
                model.addAttribute("countryOfTheRace", countryOfTheRace);
                model.addAttribute("cityOfTheRace", cityOfTheRace);
                model.addAttribute("codeToChangeTheRaceInDB", codeToChangeTheRaceInDB);
        return "changeRace_page";
    }
}
