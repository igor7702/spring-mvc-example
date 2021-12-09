package com.javamaster.controller;

import com.javamaster.dao.CreateCityInDB;
import com.javamaster.entity.Cities;
import com.javamaster.repository.GetCitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CreateCityController {

    @Autowired
    private CreateCityInDB createCityInDB;
    @Autowired
    private GetCitiesRepository getCitiesRepository;

    @GetMapping("/createCity")
    public String home(@RequestParam(required = false) Model model,
                       String PermissionCodeCountry, String nameCity) {

        int nameCityExists;

        List<Cities> citiesName = getCitiesRepository.findWhereNameCityParam(nameCity);
        citiesName.forEach(it-> System.out.println(it));
        System.out.println("citiesName.size = " + citiesName.size());
        nameCityExists = citiesName.size();

        if(nameCityExists == 0){
            createCityInDB.createCityNameParametr(nameCity);
        }

        return "answerAddGood_page.html";

    }

}