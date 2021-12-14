package com.javamaster.controller;

import com.javamaster.repository.TeamsCrudRepository;
import com.javamaster.entity.Teams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class GetTeamController {

    @Autowired
    private TeamsCrudRepository teamsCrudRepository;

    @GetMapping("/getTeams")
    public String home(@RequestParam(required = false) Model model) {

        List<Teams> teams = teamsCrudRepository.findAllTeamsDB();
        teams.forEach(it-> System.out.println(it));

        // model.addAttribute("teams", teams);

        return "getTeam_page";
    }
}