package com.javamaster.controller;

import com.javamaster.repository.TeamsCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PilotController {

    @Autowired
    private TeamsCrudRepository teamsCrudRepository;

    @GetMapping("/deleteTeam")
    public String home(@RequestParam(required = false) Model model,
                       String PermissionCodeCountry, Long idTeam, String nameTeam) {

        teamsCrudRepository.deleteVoidWhereIdParametr(idTeam);

        return "answerDeleteGood_page";
    }
}