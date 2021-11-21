package com.javamaster.controller;

import com.javamaster.dao.CreateCityInDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CreateCityController {

    @Autowired
    private CreateCityInDB createCityInDB;

    @GetMapping("/createCity")
    public String home(@RequestParam(required = false) Model model,
                       String PermissionCodeCountry, String nameCity) {

        createCityInDB.createCityNameParametr(nameCity);

        return "answerAddGood_page.html";
    }

}