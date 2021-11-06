package com.javamaster.controller;

import com.javamaster.entity.Countries;
import com.javamaster.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeleteCountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/deleteCountry")
    public String home(@RequestParam(required = false) String login, Model model,
                       String PermissionCodeCountry, String codeCountry) {

//        Countries countries = new Countries();
//        countries.setCode_country(codeCountry);
//        countryService.createCountry(countries);

        return "answerDeleteGood_page";
    }
}