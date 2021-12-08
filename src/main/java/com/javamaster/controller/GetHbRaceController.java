package com.javamaster.controller;

import com.javamaster.dao.GetHbRacesFromDB;
import com.javamaster.entity.Races;
import com.javamaster.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class GetHbRaceController {

    @Autowired
    private UserService userService;

    @Autowired
    private GetHbRacesFromDB getHbRacesFromDB;

    @GetMapping("/getHbRace")
    public String home(@RequestParam(required = false) Model model) {

        List<Races> races = getHbRacesFromDB.findAllRacesDB();
        races.forEach(it-> System.out.println(it));

        // model.addAttribute("races", races);

        return "getHbRace_page";
    }
}