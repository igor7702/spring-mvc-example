package com.javamaster.controller;

import com.javamaster.entity.Countries;
import com.javamaster.service.CountryService;
import com.javamaster.repository.GetCountriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AddCountryController {

    @Autowired
    private CountryService countryService;
    @Autowired
    private GetCountriesRepository getCountriesRepository;

    @GetMapping("/addCountry")
    public String home(@RequestParam(required = false) String login, Model model,
                       String PermissionCodeCountry, String codeCountry, String nameCountry) {

        int codeCountryExists;
        int nameCountryExists;

        Countries countries = new Countries();
        countries.setName_country(nameCountry);
        countries.setCode_country(codeCountry);

        List<Countries> countriesName = getCountriesRepository.findWhereNameCountryParam(nameCountry);
        countriesName.forEach(it-> System.out.println(it));
        System.out.println("countriesName.size = " + countriesName.size());
        nameCountryExists = countriesName.size();

        List<Countries> countriesCode = getCountriesRepository.findWhereCodeCountryParam(codeCountry);
        countriesCode.forEach(it-> System.out.println(it));
        System.out.println("countriesCode.size = " + countriesCode.size());
        codeCountryExists = countriesCode.size();

        if(codeCountryExists == 0){
            if(nameCountryExists == 0){
                countryService.createCountry(countries);
            }
        }

        return "answerAddGood_page";
    }
}