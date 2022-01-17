package com.javamaster.controller;

import com.javamaster.repository.XlsLoadResults1Repository;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

@Controller
public class CSVReadPilotsController {

    @Autowired
    private XlsLoadResults1Repository xlsLoadResults1Repository;

    @GetMapping("/ExcellReadResultsPasing")
    public String home(@RequestParam(required = false)
                       String PermissionCodeCountry, int numberStartRow, int numberEndRow) throws IOException {
        int ourIndex = 0;
        String namePilotRus = "";
        String codePilotEng = "";

        // 1 - имя гонщика по русски
        // 2 - код гонщика по английскии

        // Read XSL file
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
            namePilotRus = "";
            codePilotEng = "";

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
                    case STRING:
                        System.out.print(cell.getStringCellValue());
                        System.out.print("STRING");
                        System.out.print(ourIndex);
                        System.out.print("\t");
                        switch (ourIndex)
                        {
                            case 1:
                                namePilotRus = cell.getStringCellValue();
                                break;
                            case 2:
                                codePilotEng = cell.getStringCellValue();
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

        }

        // Заполнить поля для БД
        // Проверить, есть ли запись
        // Создать запись

        return "answerAddGood_page";
    }
}