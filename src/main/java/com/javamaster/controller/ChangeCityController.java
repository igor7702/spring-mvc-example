package com.javamaster.controller;

import com.javamaster.dao.UpdateCityFromDB;
import com.javamaster.entity.Cities;
import com.javamaster.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChangeCityController {

    @Autowired
    private UserService userService;

    @Autowired
    private UpdateCityFromDB updateCityFromDB;

    @GetMapping("/changeCity")
    public String home(@RequestParam(required = false) int codeCity, String nameCity,
                       Model model, String codeToChangeTheCityInDB) {

        updateCityFromDB.updateCityCodeParametr(codeCity, nameCity);

        return "answerAddGood_page.html";
    }
}
