package com.javamaster.controller;

import com.javamaster.dao.GetCityFromDB;
import com.javamaster.entity.Cities;
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
    private GetCityFromDB getCityFromDB;

    @GetMapping("/getHbRace")
    public String home(@RequestParam(required = false) Model model) {

        userService.findAllByName("Smith").forEach(it-> System.out.println(it));

        List<Cities> cities = getCityFromDB.findAllCitiesDB();
        cities.forEach(it-> System.out.println(it));

        // model.addAttribute("cities", cities);

        return "getCity_page";
    }
}