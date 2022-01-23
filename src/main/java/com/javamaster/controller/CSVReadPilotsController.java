package com.javamaster.controller;

import com.javamaster.repository.CsvLoadPilots1Repository;
import com.opencsv.CSVIterator;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Controller
public class CSVReadPilotsController {

    @Autowired
    private CsvLoadPilots1Repository csvLoadPilots1Repository;

    @GetMapping("/CSVReadPilotsPasing")
    public String home(@RequestParam(required = false)
                       String PermissionCodeCountry, int numberStartRow, int numberEndRow) throws IOException, CsvValidationException {
        int ourIndex = 0;
        csvLoadPilots1Repository.deleteAllTable();

        // 1 - имя гонщика по русски
        // 2 - код гонщика по английскии
        String namePilotRus = "";
        String codePilotEng = "";

        //Вариант1: Чтение в строку
        CSVReader reader = new CSVReader(new FileReader("C:/Books/info/exampleNotepadCsv.txt"));
        String [] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            // nextLine[] is an array of values from the line
            // Заполнить поля для БД
            csvLoadPilots1Repository.createAllParametr(
                    nextLine[0],
                    nextLine[1]
            );
            System.out.println(nextLine[0] + nextLine[1]);
        }

//        //Вариант2: Чтение всего файла
//        CSVReader reader = new CSVReader(new FileReader("yourfile.csv"));
//        List<String[]> myEntries = reader.readAll();

//        //Вариант3.1: Используется итератор 1
//        CSVIterator iterator = new CSVIterator(new CSVReader(new FileReader("yourfile.csv")));
//        for(String[] nextLine : iterator) {
//            // nextLine[] is an array of values from the line
//            System.out.println(nextLine[0] + nextLine[1] + "etc...");

        //Вариант3.2: Используется итератор 2
//        CSVReader reader = new CSVReader(new FileReader("yourfile.csv"));
//        for(String[] nextLine : reader.iterator()) {
//            // nextLine[] is an array of values from the line
//            System.out.println(nextLine[0] + nextLine[1] + "etc...");
//        }

        //Вариант4: Используется Bean

        return "answerAddGood_page";
    }
}