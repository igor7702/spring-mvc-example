package com.javamaster.controller;

import com.javamaster.repository.TeamsCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UpdateTeamController {

    @Autowired
    private TeamsCrudRepository teamsCrudRepository;

    @GetMapping("/updateTeam")
    public String home(@RequestParam(required = false) long idTeam, String nameTeam,
                       Model model, String codeToChangeTheCityInDB) {

        teamsCrudRepository.updateWhereIdAndNameTeamParam(nameTeam, idTeam);
        return "answerAddGood_page.html";

    }

    @GetMapping("/updateYearCodeTeam")
    public String updateYearCodeTeam(@RequestParam(required = false) long idTeam, int yearTeam, String codeTeam,
                       Model model, String codeToChangeTheCityInDB) {

        teamsCrudRepository.updateWhereYearAndCodeTeamParam(yearTeam, codeTeam, idTeam);

        return "answerAddGood_page.html";

    }

}
