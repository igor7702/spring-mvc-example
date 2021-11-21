package com.javamaster.controller;

import com.javamaster.dao.UpdateCountryFromDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChangeCountryInfoController {

    @Autowired
    private UpdateCountryFromDB updateCountryFromDB;

    @GetMapping("/changeCountryInfo")
    public String home(@RequestParam(required = false) String specialCode,
                       Model model, String codeCountry, String nameCountry) {


        return "answerAddGood_page.html";
    }
}