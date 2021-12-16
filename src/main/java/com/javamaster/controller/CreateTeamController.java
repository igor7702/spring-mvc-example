package com.javamaster.controller;

import com.javamaster.entity.Teams;
import com.javamaster.repository.TeamsCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CreateTeamController {

    @Autowired
    private TeamsCrudRepository teamsCrudRepository;

    @GetMapping("/createTeam")
    public String home(@RequestParam(required = false) Model model,
                       String PermissionCodeCountry, String nameTeam, int yearTeam, String codeTeam) {

        int nameExists;

        List<Teams> teamsName = teamsCrudRepository.findWhereNameTeamParam(nameTeam);
        teamsName.forEach(it-> System.out.println(it));
        System.out.println("citiesName.size = " + teamsName.size());
        nameExists = teamsName.size();

        teamsCrudRepository.createTeam4Parametr(nameTeam, yearTeam, codeTeam);

        return "answerAddGood_page.html";

    }

}