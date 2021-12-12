package com.javamaster.controller;

import com.javamaster.dao.GetRaceFromDB;
import com.javamaster.dao.GetHbRacesFromDB;
import com.javamaster.repository.GetRacesRepository;
import com.javamaster.entity.Races;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UpdateRaceHbController {

    @Autowired
    private GetHbRacesFromDB getHbRacesFromDB;

    @Autowired
    private GetRacesRepository getRacesRepository;

    @GetMapping("/updateRaceHb")
    public String home(@RequestParam(required = false) String numberOfTheRaceWeek,
                       Model model, String yearOfTheRace, String codeToChangeTheRaceInDB) {

        String countryOfTheRace;
        String cityOfTheRace;

        List<Races> races = getRacesRepository.findWhereWeekYearParam(numberOfTheRaceWeek, yearOfTheRace);
        races.forEach(it-> System.out.println(it));

        countryOfTheRace = races.get(0).getCountry_name_race();
        cityOfTheRace = races.get(0).getCity_name_race();

        System.out.println("Week number of the race is: " + numberOfTheRaceWeek);
        System.out.println("Year of the race is: " + yearOfTheRace);
        System.out.println("Country of the race is: " + countryOfTheRace);
        System.out.println("City of the race is: " + cityOfTheRace);

        model.addAttribute("numberOfTheRaceWeek", numberOfTheRaceWeek);
        model.addAttribute("dataOfTheRace", yearOfTheRace);
        model.addAttribute("countryOfTheRace", countryOfTheRace);
        model.addAttribute("cityOfTheRace", cityOfTheRace);
        model.addAttribute("codeToChangeTheRaceInDB", codeToChangeTheRaceInDB);

        return "changeHbRace_page";
    }
}
