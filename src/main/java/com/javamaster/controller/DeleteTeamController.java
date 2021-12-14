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
public class DeleteTeamController {

    @Autowired
    private TeamsCrudRepository teamsCrudRepository;

    @GetMapping("/deleteTeam")
    public String home(@RequestParam(required = false) Model model,
                       String PermissionCodeCountry, Long idTeam, String nameTeam) {

        List<Teams> teamsList = teamsCrudRepository.deleteWithAnswerWhereIdParametr(idTeam);

        return "answerDeleteGood_page";
    }
}