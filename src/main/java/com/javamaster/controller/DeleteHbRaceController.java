package com.javamaster.controller;

import com.javamaster.entity.Races;
import com.javamaster.repository.DeleteRacesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DeleteHbRaceController {

    @Autowired
    private DeleteRacesRepository deleteRacesRepository;

    @GetMapping("/deleteHbRace")
    public String home(@RequestParam(required = false) Model model,
                       String PermissionCodeCountry, Long id, String idRace) {

        List<Races> races = deleteRacesRepository.deleteWithAnswerWhereIdParametr(id);

        return "answerDeleteGood_page";
    }
}