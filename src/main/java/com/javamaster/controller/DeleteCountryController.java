package com.javamaster.controller;

import com.javamaster.entity.Countries;
import com.javamaster.dao.DeleteCountryFromDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeleteCountryController {

    @Autowired
    private DeleteCountryFromDB deleteCountryFromDB;

    @GetMapping("/deleteCountry")
    public String home(@RequestParam(required = false) String login, Model model,
                       String PermissionCodeCountry, String codeCountry) {

        deleteCountryFromDB.deleteCountryCodeParametr(codeCountry);

        return "answerDeleteGood_page";
    }
}