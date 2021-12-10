package com.javamaster.controller;

import com.javamaster.dao.SetHbRaceToDB;
import com.javamaster.entity.Cities;
import com.javamaster.entity.Countries;
import com.javamaster.repository.GetCitiesRepository;
import com.javamaster.repository.GetCountriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AddHbRaceInfoController {

    @Autowired
    private SetHbRaceToDB setHbRaceToDB;
    @Autowired
    private GetCitiesRepository getCitiesRepository;
    @Autowired
    private GetCountriesRepository getCountriesRepository;

    @GetMapping("/addHbRaceInfo")
    public String home(@RequestParam(required = false) String numberOfTheRaceWeek,
                       Model model, String yearOfTheRace, String countryOfTheRace,
                       String cityOfTheRace, String specialCode) {

        int nameCityExists;
        int nameCountriesExists;
        long idCity;
        long idCountry;

        String idRace = yearOfTheRace + numberOfTheRaceWeek;

        List<Countries> countriesName = getCountriesRepository.findWhereNameCountryParam(countryOfTheRace);
        countriesName.forEach(it-> System.out.println(it));
        System.out.println("citiesName.size = " + countriesName.size());
        nameCountriesExists = countriesName.size();

        List<Cities> citiesName = getCitiesRepository.findWhereNameCityParam(cityOfTheRace);
        citiesName.forEach(it-> System.out.println(it));
        System.out.println("citiesName.size = " + citiesName.size());
        nameCityExists = citiesName.size();

        if(nameCityExists == 1){
            if(nameCountriesExists == 1){
                idCity = citiesName.get(0).getId();
                idCountry = countriesName.get(0).getId();
                setHbRaceToDB.createRaceAllParams(numberOfTheRaceWeek, yearOfTheRace, countryOfTheRace,
                        cityOfTheRace, idCountry, idCity, idRace);
            }
        }

        return "answerAddRaceInfo_page";
    }
}