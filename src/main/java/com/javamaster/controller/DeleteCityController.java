package com.javamaster.controller;

import com.javamaster.dao.DeleteCityFromDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeleteCityController {

    @Autowired
    private DeleteCityFromDB deleteCityFromDB;

    @GetMapping("/deleteCity")
    public String home(@RequestParam(required = false) Model model,
                       String PermissionCodeCountry, Long idCity, String nameCity) {

        deleteCityFromDB.deleteCitiesById(idCity);

        return "answerDeleteGood_page";
    }
}