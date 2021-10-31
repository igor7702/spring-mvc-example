package com.javamaster.controller;

import com.javamaster.dao.SetRaceToDB;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddAddressUserInfoController {

    @GetMapping("/addAddressUserInfo")
    public String home(@RequestParam(required = false) String cityAddressUser,
                       Model model, String streetAddressUser, String homeNumberAddressUser,
                       String nameUser, String emailUser) {

        //SetRaceToDB raceToDBObj; - создать класс в dao для записи данных в базу данных
        //raceToDBObj = new SetRaceToDB(numberOfTheRaceWeek, yearOfTheRace, countryOfTheRace, cityOfTheRace);

        return "answerAddRaceInfo_page.html"; // используется общий темплейт о добавлении записи
    }
}