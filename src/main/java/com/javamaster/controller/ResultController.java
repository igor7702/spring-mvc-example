package com.javamaster.controller;

import com.javamaster.entity.XlsLoadResults1;
import com.javamaster.entity.Pilots;
import com.javamaster.entity.Results;
import com.javamaster.repository.PilotsCrudRepository;
import com.javamaster.repository.XlsLoadResults1Repository;
import com.javamaster.repository.ResultsCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ResultController {

    @Autowired
    private PilotsCrudRepository pilotsCrudRepository;

    @Autowired
    private XlsLoadResults1Repository xlsLoadResults1Repository;

    @Autowired
    private ResultsCrudRepository resultsCrudRepository;

    // Create
    @GetMapping("/CreateResultsRaceName")
    public String CreateResultsRaceName(@RequestParam(required = false) Model model,
                       String PermissionCodeCountry) {
        // Вар.1 Просто создать запись с именем гонки
        // Создать Create с одним параметром имя гонки (ResultsCrudRepository)
        // Протестировать (тест results)

        List<XlsLoadResults1> result = xlsLoadResults1Repository.findAllXlsLoadResults1DB();
        result.forEach(it3-> System.out.println(it3));
        System.out.println("result.size = " + result.size());
        int resultExists = result.size();

       int raceId;
       String raceName;

        if(resultExists != 0){

            // Получить первую запись из Лист, затем заменить на цикл записей
            // Получить номер гонки
            raceName = Integer.toString(result.get(0).getCountry());
            System.out.println("String raceName = " + raceName);

            //Записать номер гонки в results
            resultsCrudRepository.deleteAllTable();
            resultsCrudRepository.create1Params(raceName);
//            // По номеру гонки получить id гонки и имя гонки
//
//            // По имени гонщика получить в Pilot - код гонщика и его id
//            // Если есть результат, то получим codePilot и idPilot
//            List<Pilots> pilots = pilotsCrudRepository.findWhereNameRusParam(nameRus);
//            pilots.forEach(it4-> System.out.println(it4));
//            System.out.println("pilots.size = " + pilots.size());
//            namePilotExists = pilots.size();
//
//            if(namePilotExists != 0){
//                idPilot = pilots.get(0).getId();
//                codePilot = pilots.get(0).getCode_pilots();
//
//                // Проверить, есть ли такая запись в тб results по номеру гонки и коду пилота
//                // Если такой записи нет - записать
//                //pilotsCrudRepository.createPilotParametr(namePilot, codePilot);
//
//            }
//
        }

        return "answerAddGood_page";
    }

    // Create
    @GetMapping("/CreateResultsIdRace")
    public String CreateResultsIdRace(@RequestParam(required = false) Model model,
                                        String PermissionCodeCountry) {
        // Вар.1 Просто создать запись с id гонки
        // Создать Create с одним параметром id гонки (ResultsCrudRepository)
        // Протестировать (тест results)

        List<XlsLoadResults1> result = xlsLoadResults1Repository.findAllXlsLoadResults1DB();
        result.forEach(it3-> System.out.println(it3));
        System.out.println("result.size = " + result.size());
        int resultExists = result.size();

        int raceId = 32;
        String raceName;

        if(resultExists != 0){

            // Получить первую запись из Лист, затем заменить на цикл записей
            // Получить номер гонки
            raceName = Integer.toString(result.get(0).getCountry());
            System.out.println("String raceName = " + raceName);

            //Записать номер гонки в results
            resultsCrudRepository.deleteAllTable();
            resultsCrudRepository.create1IdParams(raceId);
//            // По номеру гонки получить id гонки и имя гонки

        }

        return "answerAddGood_page";
    }

//    // Delete
//    @GetMapping("/deletePilot")
//    public String home(@RequestParam(required = false) Model model,
//                       String PermissionCodeCountry, Long idPilot, String namePilot) {
//
//        pilotsCrudRepository.deleteVoidWhereIdParametr(idPilot);
//
//        return "answerDeleteGood_page";
//    }

//    // Update
//    @GetMapping("/UpdatePilotNameRus")
//    public String UpdatePilotNameRus(@RequestParam(required = false) Model model,
//                       String PermissionCodeCountry) {
//
//        List<Pilots> pilots = pilotsCrudRepository.findWhereNameRusNull();
//        pilots.forEach(it-> System.out.println(it.getCode_pilots()));
//
//        if (pilots.size() != 0){
//
//            for (int i = 0; i < pilots.size(); i++) {
//                Pilots element = pilots.get(i);
//                String codePilot = element.getCode_pilots();
//                System.out.println(element.getCode_pilots());
//
//                // по коду пилота, получить русское имя
//                List<CsvLoadPilots1> csvLoadPilots1s = csvLoadPilots1Repository.findWhereCodePilotEng(codePilot);
//
//                if (csvLoadPilots1s.size() != 0){
//                    String namePilotRus = csvLoadPilots1s.get(0).getNamepilotrus();
//
//                    // по id пилота и русского имени обновить тб pilots
//                    pilotsCrudRepository.updateWhereNameRusAndIdParam(namePilotRus, element.getId());
//                }
//            }
//        }
//
//        // Из таблицы Pilots получить все записи, где nameRus=Null
//        // Получить codePilot
//        // по codePilot получить запсиь из тб csvpilots
//        // получть id записи
//        // обновить таблицу pilots колонка nameRus
//
//        return "answerAddGood_page";
//    }

}