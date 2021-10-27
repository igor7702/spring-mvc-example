package com.javamaster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChangeRaceController {

    @GetMapping("/changeRace")
    public String home(@RequestParam(required = false) String numberOfTheRaceWeek,
                       Model model, String yearOfTheRace, String codeToChangeTheRaceInDB) {
                model.addAttribute("numberOfTheRaceWeek", numberOfTheRaceWeek);
                model.addAttribute("yearOfTheRace", yearOfTheRace);
                model.addAttribute("codeToChangeTheRaceInDB", codeToChangeTheRaceInDB);
        return "changeRace_page";
    }
}
