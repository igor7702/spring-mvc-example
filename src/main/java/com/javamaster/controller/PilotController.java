package com.javamaster.controller;

import com.javamaster.entity.Pilots;
import com.javamaster.repository.PilotsCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PilotController {

    @Autowired
    private PilotsCrudRepository pilotsCrudRepository;

    // Create
    @GetMapping("/createPilot")
    public String createPilot(@RequestParam(required = false) Model model,
                       String PermissionCodeCountry, String namePilot) {

        String codePilot = "";
        int phraseLength = namePilot.length();
        int index1 = namePilot.indexOf(' ');
        int namePilotExists;

        if (index1 != -1){
            codePilot = namePilot.substring(index1 + 1);
        }

        System.out.println("Мы ищем букву ' ' в строке "+namePilot+". Индекс данной буквы "+index1 );

        List<Pilots> pilotsName = pilotsCrudRepository.findWhereNamePilotParam(namePilot);
        pilotsName.forEach(it-> System.out.println(it));
        System.out.println("pilotsName.size = " + pilotsName.size());
        namePilotExists = pilotsName.size();

        if(namePilotExists == 0){
             pilotsCrudRepository.createPilotParametr(namePilot, codePilot);
        }

        return "answerAddGood_page";
    }

    // Delete
    @GetMapping("/deletePilot")
    public String home(@RequestParam(required = false) Model model,
                       String PermissionCodeCountry, Long idPilot, String namePilot) {

        pilotsCrudRepository.deleteVoidWhereIdParametr(idPilot);

        return "answerDeleteGood_page";
    }

    // Update
    // Get
}