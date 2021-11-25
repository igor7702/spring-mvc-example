package com.javamaster.controller;

import com.javamaster.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BooksController {

    @GetMapping("/operationBook")
    public String home(@RequestParam(required = false) Model model) {

        //DeleteRaceFromDB raceFromDBObj;

        //raceFromDBObj = new DeleteRaceFromDB(numberOfTheRaceWeek, yearOfTheRace, codeToDeleteTheRaceFromDB);

        return "answerDeleteRace_page";
    }
}