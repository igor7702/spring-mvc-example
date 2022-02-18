package com.javamaster.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

import com.javamaster.repository.XlsLoadResults1Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExcellReadResultsController {

    @Autowired
    private XlsLoadResults1Repository xlsLoadResults1Repository;

    @GetMapping("/ExcellReadResultsPasing")
    public String home(@RequestParam(required = false)
                       String PermissionCodeCountry, int numberStartRow, int numberEndRow) throws IOException {
        int ourIndex = 0;
        int position = 0;
        int numberPilot = 0;
        String namePilot = "";
        String team = "";
        String motor = "";
        int laps = 0;
        String raceTime = "";
        String lead = "";
        String gap = "";
        int pitStops = 0;
        String crash = "";
        int points = 0;
        int country = 0;

        xlsLoadResults1Repository.deleteAllTable();

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

        // Read XSL file
        //FileInputStream inputStream = new FileInputStream(new File("C:/Books/info/F1ExampleXLS_OneRow.xls"));
        FileInputStream inputStream = new FileInputStream(new File("C:/Books/info/F1ExampleXLSBig.xls"));

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
            ourIndex = 0;
            position = 0; //1
            numberPilot = 0; //2
            namePilot = ""; //3
            team = ""; //4
            motor = ""; //5
            laps = 0; //6
            raceTime = ""; //7
            lead = ""; //8
            gap = ""; //9
            pitStops = 0; //10
            crash = ""; //11
            points = 0; //12
            country = 0; //13

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
                            case 1: //position
                                position = (int) cell.getNumericCellValue();
                                break;
                            case 2: //numberpilot
                                numberPilot = (int) cell.getNumericCellValue();
                                break;
                            case 6:
                                laps = (int) cell.getNumericCellValue();
                                break;
                            case 10:
                                pitStops = (int) cell.getNumericCellValue();
                                break;
                            case 12:
                                points = (int) cell.getNumericCellValue();
                                break;
                            case 13:
                                country = (int) cell.getNumericCellValue();
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
                            case 3: //namepilot
                                String s = cell.getStringCellValue();
                                namePilot = s.substring(1);
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
//                            case 11:
//                                crash = cell.getStringCellValue();
//                                break;
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

            // Для базы данных
            // Заполнить первичную таблицу
//            xlsLoadResults1Repository.createAllParametr(
//                    position,
//                    numberPilot,
//                    namePilot,
//                    team,
//                    motor,
//                    laps,
//                    raceTime,
//                    lead,
//                    gap,
//                    pitStops,
//                    crash,
//                    points,
//                    country
//            );

//            xlsLoadResults1Repository.create1Parametr(
//                    position
//            );

//            xlsLoadResults1Repository.create2Parametr(
//                    position,
//                    numberPilot
//            );

//            xlsLoadResults1Repository.create3Parametr(
//                    position,
//                    numberPilot,
//                    namePilot
//            );

//            xlsLoadResults1Repository.create4Parametr(
//                    position,
//                    numberPilot,
//                    namePilot,
//                    team
//            );

//            xlsLoadResults1Repository.create5Parametr(
//                    position,
//                    numberPilot,
//                    namePilot,
//                    team,
//                    motor
//            );

//            xlsLoadResults1Repository.create6Parametr(
//                    position,
//                    numberPilot,
//                    namePilot,
//                    team,
//                    motor,
//                    laps
//            );

//            xlsLoadResults1Repository.create7Parametr(
//                    position,
//                    numberPilot,
//                    namePilot,
//                    team,
//                    motor,
//                    laps,
//                    raceTime
//            );

//            xlsLoadResults1Repository.create8Parametr(
//                    position,
//                    numberPilot,
//                    namePilot,
//                    team,
//                    motor,
//                    laps,
//                    raceTime,
//                    lead
//            );

//            xlsLoadResults1Repository.create9Parametr(
//                    position,
//                    numberPilot,
//                    namePilot,
//                    team,
//                    motor,
//                    laps,
//                    raceTime,
//                    lead,
//                    gap
//            );

//            xlsLoadResults1Repository.create10Parametr(
//                    position,
//                    numberPilot,
//                    namePilot,
//                    team,
//                    motor,
//                    laps,
//                    raceTime,
//                    lead,
//                    gap,
//                    pitStops
//            );

//            xlsLoadResults1Repository.create11Parametr(
//                    position,
//                    numberPilot,
//                    namePilot,
//                    team,
//                    motor,
//                    laps,
//                    raceTime,
//                    lead,
//                    gap,
//                    pitStops,
//                    crash
//            );

//            xlsLoadResults1Repository.create12Parametr(
//                    position,
//                    numberPilot,
//                    namePilot,
//                    team,
//                    motor,
//                    laps,
//                    raceTime,
//                    lead,
//                    gap,
//                    pitStops,
//                    crash,
//                    points
//            );

            xlsLoadResults1Repository.create13Parametr(
                    position,
                    numberPilot,
                    namePilot,
                    team,
                    motor,
                    laps,
                    raceTime,
                    lead,
                    gap,
                    pitStops,
                    crash,
                    points,
                    country
            );
        }

//        // Определить все поля для базы result
//        String raceName = "" + ((int) country); // определить по номеру года и стране
//        int raceId = 0; // определить по номеру года и стране
//        int typeRaceId = 1; // Определить как Main
//        String typeRaceName = ""; // Определить как Main

//        // team
//        int yearTeam = Integer.parseInt (raceName.substring(0, 4));
//        String teamNameForQuery = team.trim();
//        List<Teams> teamFromDB = teamsCrudRepository.findWhereNameTeamAndYearParam(yearTeam, teamNameForQuery);  // Запросом получить из БД
//        //Teams teamName = teamFromDB.get(1);
//        int teamId = 0;

//        int lap = (int) Math.round(laps);
//        boolean bestlap = false;
//        int startGreed = 0;
//        int endGreed = (int) Math.round(position);
//        int pointsPilot = (int) Math.round(points);
//        int pointsPilotAll = 0;
//        int pointsTeam = (int) Math.round(points);;
//        int pointsTeamAll = 0;

        // Заполнить поля для БД
        // Проверить, есть ли запись
        // Создать запись

        return "answerAddGood_page";
    }
}