package com.javamaster.controller;

import com.javamaster.entity.Countries;
import com.javamaster.entity.Users;
import com.javamaster.service.CountryService;
import com.javamaster.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddCountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/addCountry")
    public String home(@RequestParam(required = false) String login, Model model,
                       String PermissionCodeCountry, String codeCountry, String nameCountry) {

        Countries countries = new Countries();
        countries.setName(nameCountry);
        countries.setCodeCountry(codeCountry);
        countryService.createCountry(countries);

        return "answerAddGood_page";
    }
}

//    Users users = new Users();
//        users.setAddress(address);
//                users.setEmail(emailUser);
//                users.setName(nameUser);
//                userService.createUsers(users);