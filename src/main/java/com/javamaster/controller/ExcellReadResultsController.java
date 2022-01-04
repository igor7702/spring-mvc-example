package com.javamaster.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExcellReadResultsController {

    @GetMapping("/ExcellReadResultsPasing")
    public String home(@RequestParam(required = false)
                       String PermissionCodeCountry, int numberStartRow, int numberEndRow) throws IOException {
        int ourIndex = 0;
        double position = 0;
        double numberPilot = 0;
        String namePilot = "";
        String team = "";
        String motor = "";
        double laps = 0;
        String raceTime = "";
        String lead = "";
        String gap = "";
        double pitStops = 0;
        String crash = "";
        double points = 0;
        String country = "";
        double year = 0;

        // 1 - позиция по завершению гонки
        // 2 - номер гонщика
        // 3 - имя гонщика
        // 4 - команда
        // 5 - мотор
        // 6 - круги
        // 7 - время - Часы, минуты, секунды/ long - количество милисекунд
        // 8 - отрыв - Часы, минуты, секунды/ long - количество милисекунд
        // 9 - отставание кмч
        // 10 - пит-стопов
        // 11 - сход
        // 12 - очки
        // 13 - страна
        // 14 - год

        // Read XSL file
        FileInputStream inputStream = new FileInputStream(new File("C:/Books/info/F1ExampleXLS_OneRow.xls"));

        // Get the workbook instance for XLS file
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);

        // Get first sheet from the workbook
        HSSFSheet sheet = workbook.getSheetAt(0);

        // Get iterator to all the rows in current sheet
        Iterator<Row> rowIterator = sheet.iterator();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            // Get iterator to all cells of current row
            Iterator<Cell> cellIterator = row.cellIterator();

            // Инициализация полей в начальное значение
            position = 0;
            numberPilot = 0;
            namePilot = "";
            team = "";
            motor = "";
            laps = 0;
            raceTime = "";
            lead = "";
            gap = "";
            pitStops = 0;
            crash = "";
            points = 0;
            country = "";
            year = 0;

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                // Change to getCellType() if using POI 4.x
                CellType cellType = cell.getCellType();

                ourIndex = ourIndex + 1;
                switch (cellType) {
                    case _NONE:
                        System.out.print("");
                        System.out.print("NONE");
                        System.out.print(ourIndex);
                        System.out.print("\t");
                        break;
                    case BOOLEAN:
                        System.out.print(cell.getBooleanCellValue());
                        System.out.print("BOOLEAN");
                        System.out.print(ourIndex);
                        System.out.print("\t");
                        break;
                    case BLANK:
                        System.out.print("");
                        System.out.print("BLANK");
                        System.out.print(ourIndex);
                        System.out.print("\t");
                        break;
                    case FORMULA:
                        // Formula
                        System.out.print(cell.getCellFormula());
                        System.out.print("FORMULA");
                        System.out.print(ourIndex);
                        System.out.print("\t");

                        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
                        // Print out value evaluated by formula
                        System.out.print(evaluator.evaluate(cell).getNumberValue());
                        break;
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue());
                        System.out.print("NUMERIC");
                        System.out.print(ourIndex);
                        System.out.print("\t");

                        switch (ourIndex)
                        {
                            case 1:
                                position = cell.getNumericCellValue();
                                break;
                            case 2:
                                numberPilot = cell.getNumericCellValue();
                                break;
                            case 6:
                                laps = cell.getNumericCellValue();
                                break;
                            case 10:
                                pitStops = cell.getNumericCellValue();
                                break;
                            case 12:
                                points = cell.getNumericCellValue();
                                break;
                            case 14:
                                year = cell.getNumericCellValue();
                                break;
                        }
                        break;
                    case STRING:
                        System.out.print(cell.getStringCellValue());
                        System.out.print("STRING");
                        System.out.print(ourIndex);
                        System.out.print("\t");
                        switch (ourIndex)
                        {
                            case 3:
                                namePilot = cell.getStringCellValue();
                                break;
                            case 4:
                                team = cell.getStringCellValue();
                                break;
                            case 5:
                                motor = cell.getStringCellValue();
                                break;
                            case 7:
                                raceTime = cell.getStringCellValue();
                                break;
                            case 8:
                                lead = cell.getStringCellValue();
                                break;
                            case 9:
                                gap = cell.getStringCellValue();
                                break;
                            case 11:
                                crash = cell.getStringCellValue();
                                break;
                            case 13:
                                country = cell.getStringCellValue();
                                break;
                        }
                        break;
                    case ERROR:
                        System.out.print("!");
                        System.out.print("ERROR");
                        System.out.print(ourIndex);
                        System.out.print("\t");
                        break;
                }

            }
            System.out.println("");
        }

        // Для базы данных
        // Определить все поля для базы result
        int raceId = 0; // определить по номеру года и стране
        String raceName = ""; // определить по номеру года и стране
        int typeRaceId = 0; // Определить как Main
        String typeRaceName = ""; // Определить как Main
        int teamId = 0;
        String teamName = "";
        int lap = (int) Math.round(laps);
        boolean bestlap = false;
        int startGreed = 0;
        int endGreed = (int) Math.round(position);
        int pointsPilot = (int) Math.round(points);
        int pointsPilotAll = 0;
        int pointsTeam = (int) Math.round(points);;
        int pointsTeamAll = 0;

        // Заполнить поля для БД
        // Проверить, есть ли запись
        // Создать запись

        return "answerAddGood_page";
    }
}