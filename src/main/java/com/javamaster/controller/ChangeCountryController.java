package com.javamaster.controller;

import com.javamaster.dao.GetCountryFromDB;
import com.javamaster.entity.Countries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChangeCountryController {

    @Autowired
    private GetCountryFromDB getCountryFromDB;

    @GetMapping("/changeCountry")
    public String home(@RequestParam(required = false) String codeCountry,
                       Model model, String codeToChangeTheCountryInDB) {

        String nameCountry = "";

        Countries countries = getCountryFromDB.findWhereCodeCountryParam(codeCountry).get(0);
        nameCountry=countries.getName_country();

        System.out.println("The code of the country is: " + codeCountry);
        System.out.println("The name of the country is: " + nameCountry);

        model.addAttribute("codeCountry", codeCountry);
        model.addAttribute("nameCountry", nameCountry);
        model.addAttribute("codeToChangeTheCountryInDB", codeToChangeTheCountryInDB);
        return "changeCountry_page";
    }
}
