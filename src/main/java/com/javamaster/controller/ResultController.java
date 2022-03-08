package com.javamaster.controller;

import com.javamaster.entity.XlsLoadResults1;
import com.javamaster.entity.Pilots;
import com.javamaster.entity.Results;
import com.javamaster.entity.Races;
import com.javamaster.repository.PilotsCrudRepository;
import com.javamaster.repository.XlsLoadResults1Repository;
import com.javamaster.repository.ResultsCrudRepository;
import com.javamaster.repository.GetRacesRepository;
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

    @Autowired
    private GetRacesRepository getRacesRepository;

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
    @GetMapping("/CreateResultsAllRaceName")
    public String CreateResultsAllRaceName(@RequestParam(required = false) Model model,
                                        String PermissionCodeCountry) {
        // Вар.1 Просто создать запись с именем гонки
        // Создать Create с одним параметром имя гонки (ResultsCrudRepository)
        // Протестировать (тест results)
        // Добавить все записи, цикл

        List<XlsLoadResults1> result = xlsLoadResults1Repository.findAllXlsLoadResults1DB();
        result.forEach(it3-> System.out.println(it3));
        System.out.println("result.size = " + result.size());
        int resultExists = result.size();

        int raceId;
        String raceName;

        if(resultExists != 0){

            // Заменить на цикл записей
            // result.size() - всего записей
            resultsCrudRepository.deleteAllTable();
            for (int i = 0; i <= (resultExists - 1); i++){

                // Получить номер гонки
                raceName = Integer.toString(result.get(i).getCountry());
                System.out.println("String raceName = " + raceName);

                //Записать номер гонки в results
                resultsCrudRepository.create1Params(raceName);
            }
        }

        return "answerAddGood_page";
    }

    // Create
    @GetMapping("/CreateResultsAllIdRace")
    public String CreateResultsAllIdRace(@RequestParam(required = false) Model model,
                                           String PermissionCodeCountry) {
        // Вар.1 Просто создать запись с именем гонки
        // Создать Create с одним параметром имя гонки (ResultsCrudRepository)
        // Протестировать (тест results)
        // Добавить все записи, цикл

        List<XlsLoadResults1> result = xlsLoadResults1Repository.findAllXlsLoadResults1DB();
        result.forEach(it3-> System.out.println(it3));
        System.out.println("result.size = " + result.size());
        int resultExists = result.size();

        int raceId;
        String raceName;

        if(resultExists != 0){

            // Заменить на цикл записей
            // result.size() - всего записей
            resultsCrudRepository.deleteAllTable();
            for (int i = 0; i < 20; i++){

                // Получить номер гонки
                System.out.println("String raceName = " + i);

                //Записать номер гонки в results
                resultsCrudRepository.create1IdParams(i);
            }
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

    // Create
    @GetMapping("/CreateResultsRaceNameAndSimpleIdRace")
    public String CreateResultsRaceNameAndSimpleIdRace(@RequestParam(required = false) Model model,
                                      String PermissionCodeCountry) {
        // Вар.1 Просто создать запись с id гонки и именем гонки
        // Создать Create с двумя параметрами id гонки и именем гонки (ResultsCrudRepository)
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
            resultsCrudRepository.create2raceIdAndRaceNameParams(raceId, raceName);
//            // По номеру гонки получить id гонки и имя гонки

        }

        return "answerAddGood_page";
    }

   // Create
   @GetMapping("/CreateResultsRaceNameAndSimpleIdRaceAll")
   public String CreateResultsRaceNameAndSimpleIdRaceAll(@RequestParam(required = false) Model model,
                                                      String PermissionCodeCountry) {
       // Вар.1 Просто создать запись с id гонки и именем гонки
       // Создать Create с двумя параметрами id гонки и именем гонки (ResultsCrudRepository)
       // Протестировать (тест results)

       List<XlsLoadResults1> result = xlsLoadResults1Repository.findAllXlsLoadResults1DB();
       result.forEach(it3-> System.out.println(it3));
       System.out.println("result.size = " + result.size());
       int resultExists = result.size();

       int raceId = 32;
       String raceName;

       if(resultExists != 0){
           resultsCrudRepository.deleteAllTable();
           for (int i = 0; i < 20; i++){
               // Получить первую запись из Лист, затем заменить на цикл записей
               // Получить номер гонки
               raceName = Integer.toString(result.get(i).getCountry());
               System.out.println("String raceName = " + raceName);

               //Записать номер гонки в results
               resultsCrudRepository.create2raceIdAndRaceNameParams(raceId, raceName);
               // По номеру гонки получить id гонки и имя гонки
           }
       }

       return "answerAddGood_page";
   }

    // Create
    @GetMapping("/CreateResultsRaceNameAndRealIdRace")
    public String CreateResultsRaceNameAndRealIdRace(@RequestParam(required = false) Model model,
                                                       String PermissionCodeCountry) {
        // Вар.1 Просто создать запись с id гонки и именем гонки
        // Создать Create с двумя параметрами id гонки и именем гонки (ResultsCrudRepository)
        // Протестировать (тест results)

        List<XlsLoadResults1> result = xlsLoadResults1Repository.findAllXlsLoadResults1DB();
        result.forEach(it3-> System.out.println(it3));
        System.out.println("result.size = " + result.size());
        int resultExists = result.size();

        int raceId = 0;
        String raceName;

        if(resultExists != 0){

            // Получить первую запись из Лист XlsLoadResults1, затем заменить на цикл записей
            // Получить номер гонки
            raceName = Integer.toString(result.get(0).getCountry());
            System.out.println("String raceName = " + raceName);

            // Получить по имя гонки id гонки из тб races имя поля id_race
            List<Races> resultRaces = getRacesRepository.findWhereIdRaceParam(raceName);
            resultRaces.forEach(it3-> System.out.println(it3));
            System.out.println("resultRaces.size = " + resultRaces.size());
            int resultRacesExists = result.size();

            if(resultRacesExists != 0){
                raceId = resultRaces.get(0).getId().intValue();
                System.out.println("String raceId = " + raceId);
            }

            //Записать номер гонки в results
            resultsCrudRepository.deleteAllTable();
            resultsCrudRepository.create2raceIdAndRaceNameParams(raceId, raceName);

        }

        return "answerAddGood_page";
    }

    // Create
    @GetMapping("/CreateResultsRaceNameAndRealIdRaceAll")
    public String CreateResultsRaceNameAndRealIdRaceAll(@RequestParam(required = false) Model model,
                                                     String PermissionCodeCountry) {
        // Вар.1 Просто создать запись с id гонки и именем гонки
        // Создать Create с двумя параметрами id гонки и именем гонки (ResultsCrudRepository)
        // Протестировать (тест results)

        List<XlsLoadResults1> result = xlsLoadResults1Repository.findAllXlsLoadResults1DB();
        result.forEach(it3-> System.out.println(it3));
        System.out.println("result.size = " + result.size());
        int resultExists = result.size();

        int raceId = 0;
        String raceName;

        if(resultExists != 0){
            resultsCrudRepository.deleteAllTable();
            for (int i = 0; i < 20; i++){

                // Получить первую запись из Лист XlsLoadResults1, затем заменить на цикл записей
                // Получить номер гонки
                raceName = Integer.toString(result.get(i).getCountry());
                System.out.println("String raceName = " + raceName);

                // Получить по имя гонки id гонки из тб races имя поля id_race
                List<Races> resultRaces = getRacesRepository.findWhereIdRaceParam(raceName);
                resultRaces.forEach(it3-> System.out.println(it3));
                System.out.println("resultRaces.size = " + resultRaces.size());
                int resultRacesExists = result.size();

                if(resultRacesExists != 0){
                    raceId = resultRaces.get(0).getId().intValue();
                    System.out.println("String raceId = " + raceId);
                }

                //Записать номер гонки в results
                resultsCrudRepository.create2raceIdAndRaceNameParams(raceId, raceName);

            }
        }
        return "answerAddGood_page";
    }

    // Create
    @GetMapping("/CreateResultsRaceNameAndRealIdRacePilotNameAndPilotId")
    public String CreateResultsRaceNameAndRealIdRacePilotNameAndPilotId(@RequestParam(required = false) Model model,
                                                     String PermissionCodeCountry) {
        // Вар.1 Просто создать запись с id гонки и именем гонки
        // Создать Create с двумя параметрами id гонки и именем гонки (ResultsCrudRepository)
        // Протестировать (тест results)

        List<XlsLoadResults1> result = xlsLoadResults1Repository.findAllXlsLoadResults1DB();
        result.forEach(it3-> System.out.println(it3));
        System.out.println("result.size = " + result.size());
        int resultExists = result.size();

        int raceId = 0;
        String raceName;

        if(resultExists != 0){

            // Блок races
            // Получить первую запись из Лист XlsLoadResults1, затем заменить на цикл записей
            // Получить номер гонки
            raceName = Integer.toString(result.get(0).getCountry());
            System.out.println("String raceName = " + raceName);

            // Получить по имя гонки id гонки из тб races имя поля id_race
            List<Races> resultRaces = getRacesRepository.findWhereIdRaceParam(raceName);
            resultRaces.forEach(it3-> System.out.println(it3));
            System.out.println("resultRaces.size = " + resultRaces.size());
            int resultRacesExists = result.size();

            if(resultRacesExists != 0){
                raceId = resultRaces.get(0).getId().intValue();
                System.out.println("String raceId = " + raceId);
            }

            //Записать номер гонки в results
            resultsCrudRepository.deleteAllTable();
            resultsCrudRepository.create2raceIdAndRaceNameParams(raceId, raceName);

        }

        return "answerAddGood_page";
    }

    // Pilots
    // Create
    @GetMapping("/CreateResultsPilotName")
    public String CreateResultsPilotName(@RequestParam(required = false) Model model,
                                        String PermissionCodeCountry) {
        // Вар.1 Просто создать запись с именем Пилота
        // Создать Create с одним параметром имя Пилота (ResultsCrudRepository)
        // Протестировать (тест results)

        List<XlsLoadResults1> result = xlsLoadResults1Repository.findAllXlsLoadResults1DB();
        result.forEach(it3-> System.out.println(it3));
        System.out.println("result.size = " + result.size());
        int resultExists = result.size();

        int pilotId;
        String pilotName;

        if(resultExists != 0){

            // Получить первую запись из Лист, затем заменить на цикл записей
            // Получить имя пилота
            pilotName = result.get(0).getNamepilot();
            System.out.println("String pilotName = " + pilotName);

            //Записать имя пилота в results
            resultsCrudRepository.deleteAllTable();
            resultsCrudRepository.create1ParamsPilotName(pilotName);

        }

        return "answerAddGood_page";
    }

    // Create
    @GetMapping("/CreateResultsPilotNameAndPilotIdFromTablePilots")
    public String CreateResultsPilotNameAndPilotIdFromTablePilots(@RequestParam(required = false) Model model,
                                         String PermissionCodeCountry) {
        // Вар.1 Просто создать запись с именем Пилота
        // Создать Create с одним параметром имя Пилота (ResultsCrudRepository)
        // Протестировать (тест results)

        List<XlsLoadResults1> result = xlsLoadResults1Repository.findAllXlsLoadResults1DB();
        result.forEach(it3-> System.out.println(it3));
        System.out.println("result.size = " + result.size());
        int resultExists = result.size();

        int pilotId;
        String pilotName;
        String pilotCode;

        if(resultExists != 0){

            // Получить первую запись из Лист, затем заменить на цикл записей
            // Получить имя пилота
            pilotName = result.get(0).getNamepilot();
            System.out.println("String pilotName = " + pilotName);

            //По русскому имени пилота найти запись в тб Pilots -
            //английский код пилота
            List<Pilots> resultPilot = pilotsCrudRepository.findWhereNameRusParam(pilotName);
            resultPilot.forEach(it4-> System.out.println(it4));
            System.out.println("result.size = " + result.size());
            int resultPilotExists = resultPilot.size();

            pilotCode = resultPilot.get(0).getCode_pilots();
            pilotId=resultPilot.get(0).getId().intValue();

            System.out.println("String pilotCode = " + pilotCode);
            System.out.println("String pilotId = " + pilotId);

            //Записать имя пилота и id пилота в results
            resultsCrudRepository.deleteAllTable();
            // Создать и протестировать метод записи 2-х параметров
            resultsCrudRepository.create2pilotIdAndPilotNameParams(pilotId, pilotCode);

        }

        return "answerAddGood_page";
    }

    // Create
    @GetMapping("/CreateResultsPilotNameAndPilotIdFromTablePilotsAll")
    public String CreateResultsPilotNameAndPilotIdFromTablePilotsAll(@RequestParam(required = false) Model model,
                                                                  String PermissionCodeCountry) {
        // Вар.1 Просто создать запись с именем Пилота
        // Создать Create с одним параметром имя Пилота (ResultsCrudRepository)
        // Протестировать (тест results)

        List<XlsLoadResults1> result = xlsLoadResults1Repository.findAllXlsLoadResults1DB();
        result.forEach(it3-> System.out.println(it3));
        System.out.println("result.size = " + result.size());
        int resultExists = result.size();

        int pilotId;
        String pilotName;
        String pilotCode;

        resultsCrudRepository.deleteAllTable();
        if(resultExists != 0){
            for (int i = 0; i < 20; i++){
                // Получить первую запись из Лист, затем заменить на цикл записей
                // Получить имя пилота

                pilotName = result.get(i).getNamepilot();
                System.out.println("String pilotName = " + pilotName);

                //По русскому имени пилота найти запись в тб Pilots -
                //английский код пилота
                List<Pilots> resultPilot = pilotsCrudRepository.findWhereNameRusParam(pilotName);
                resultPilot.forEach(it4-> System.out.println(it4));
                System.out.println("result.size = " + result.size());
                int resultPilotExists = resultPilot.size();
                if(resultExists != 0){

                    pilotCode = resultPilot.get(0).getCode_pilots();
                    pilotId=resultPilot.get(0).getId().intValue();

                    System.out.println("String pilotCode = " + pilotCode);
                    System.out.println("String pilotId = " + pilotId);

                    //Записать имя пилота и id пилота в results
                    // Создать и протестировать метод записи 2-х параметров
                    resultsCrudRepository.create2pilotIdAndPilotNameParams(pilotId, pilotCode);
                }

            }

        }

        return "answerAddGood_page";
    }

    // Create
    @GetMapping("/CreateResultRacesAndPilots")
    public String CreateResultRacesAndPilots(@RequestParam(required = false) Model model,
                                                                  String PermissionCodeCountry) {
        // Блок Pilot
        // Вар.1 Просто создать запись с именем Пилота
        // Создать Create с одним параметром имя Пилота (ResultsCrudRepository)
        // Протестировать (тест results)

        List<XlsLoadResults1> result = xlsLoadResults1Repository.findAllXlsLoadResults1DB();
        result.forEach(it3-> System.out.println(it3));
        System.out.println("result.size = " + result.size());
        int resultExists = result.size();

        int pilotId;
        String pilotName;
        String pilotCode;
        int raceId=0;

        resultsCrudRepository.deleteAllTable();

        if(resultExists != 0){

            // Получить первую запись из Лист, затем заменить на цикл записей
            // Получить имя пилота
            pilotName = result.get(0).getNamepilot();
            System.out.println("String pilotName = " + pilotName);

            //По русскому имени пилота найти запись в тб Pilots -
            //английский код пилота
            List<Pilots> resultPilot = pilotsCrudRepository.findWhereNameRusParam(pilotName);
            resultPilot.forEach(it4-> System.out.println(it4));
            System.out.println("result.size = " + result.size());
            int resultPilotExists = resultPilot.size();

            pilotCode = resultPilot.get(0).getCode_pilots();
            pilotId=resultPilot.get(0).getId().intValue();

            System.out.println("String pilotCode = " + pilotCode);
            System.out.println("String pilotId = " + pilotId);

            // Блок RACES
            // Получить первую запись из Лист XlsLoadResults1, затем заменить на цикл записей
            // Получить номер гонки

            String raceName = Integer.toString(result.get(0).getCountry());
            System.out.println("String raceName = " + raceName);

            // Получить по имя гонки id гонки из тб races имя поля id_race
            List<Races> resultRaces = getRacesRepository.findWhereIdRaceParam(raceName);
            resultRaces.forEach(it3-> System.out.println(it3));
            System.out.println("resultRaces.size = " + resultRaces.size());
            int resultRacesExists = result.size();

            if(resultRacesExists != 0){
                raceId = resultRaces.get(0).getId().intValue();
                System.out.println("String raceId = " + raceId);
            }

            //Записать номер гонки в results - создать метод в репозитори - на запись 4-х параметров idRace, nameRace, idPilot, namePilot
            resultsCrudRepository.create4_IdPilot_PilotName_IdRace_NameRaceParams(pilotId, pilotCode, raceId, raceName);

        }

        return "answerAddGood_page";
    }

    // Create
    @GetMapping("/CreateResultRacesAndPilotsAll")
    public String CreateResultRacesAndPilotsAll(@RequestParam(required = false) Model model,
                                             String PermissionCodeCountry) {
        // Блок Pilot
        // Вар.1 Просто создать запись с именем Пилота
        // Создать Create с одним параметром имя Пилота (ResultsCrudRepository)
        // Протестировать (тест results)

        List<XlsLoadResults1> result = xlsLoadResults1Repository.findAllXlsLoadResults1DB();
        result.forEach(it3-> System.out.println(it3));
        System.out.println("result.size = " + result.size());
        int resultExists = result.size();

        int pilotId;
        String pilotName;
        String pilotCode;
        int raceId=0;

        resultsCrudRepository.deleteAllTable();

        for (int i = 0; i < 20; i++){
            if(resultExists != 0){

                // Получить первую запись из Лист, затем заменить на цикл записей
                // Получить имя пилота
                pilotName = result.get(i).getNamepilot();
                System.out.println("String pilotName = " + pilotName);

                //По русскому имени пилота найти запись в тб Pilots -
                //английский код пилота
                List<Pilots> resultPilot = pilotsCrudRepository.findWhereNameRusParam(pilotName);
                resultPilot.forEach(it4-> System.out.println(it4));
                System.out.println("result.size = " + result.size());
                int resultPilotExists = resultPilot.size();

                pilotCode = resultPilot.get(0).getCode_pilots();
                pilotId=resultPilot.get(0).getId().intValue();

                System.out.println("String pilotCode = " + pilotCode);
                System.out.println("String pilotId = " + pilotId);

                // Блок RACES
                // Получить первую запись из Лист XlsLoadResults1, затем заменить на цикл записей
                // Получить номер гонки

                String raceName = Integer.toString(result.get(i).getCountry());
                System.out.println("String raceName = " + raceName);

                // Получить по имя гонки id гонки из тб races имя поля id_race
                List<Races> resultRaces = getRacesRepository.findWhereIdRaceParam(raceName);
                resultRaces.forEach(it3-> System.out.println(it3));
                System.out.println("resultRaces.size = " + resultRaces.size());
                int resultRacesExists = result.size();

                if(resultRacesExists != 0){
                    raceId = resultRaces.get(0).getId().intValue();
                    System.out.println("String raceId = " + raceId);
                }

                //Записать номер гонки в results - создать метод в репозитори - на запись 4-х параметров idRace, nameRace, idPilot, namePilot
                resultsCrudRepository.create4_IdPilot_PilotName_IdRace_NameRaceParams(pilotId, pilotCode, raceId, raceName);

            }

        }

        return "answerAddGood_page";
    }

    // Create
    @GetMapping("/CreateResultsPilotNameFromTablePilots")
    public String CreateResultsPilotNameFromTablePilots(@RequestParam(required = false) Model model,
                                                        String PermissionCodeCountry) {
        // Вар.1 Просто создать запись с именем Пилота
        // Создать Create с одним параметром имя Пилота (ResultsCrudRepository)
        // Протестировать (тест results)

        List<XlsLoadResults1> result = xlsLoadResults1Repository.findAllXlsLoadResults1DB();
        result.forEach(it3-> System.out.println(it3));
        System.out.println("result.size = " + result.size());
        int resultExists = result.size();

        int pilotId;
        String pilotName;
        String pilotCode;

        if(resultExists != 0){

            // Получить первую запись из Лист, затем заменить на цикл записей
            // Получить имя пилота
            pilotName = result.get(0).getNamepilot();
            System.out.println("String pilotName = " + pilotName);

            //По русскому имени пилота найти запись в тб Pilots -
            //английский код пилота
            List<Pilots> resultPilot = pilotsCrudRepository.findWhereNameRusParam(pilotName);
            resultPilot.forEach(it4-> System.out.println(it4));
            System.out.println("result.size = " + result.size());
            int resultPilotExists = resultPilot.size();

            pilotCode = resultPilot.get(0).getCode_pilots();
            pilotId=resultPilot.get(0).getId().intValue();

            System.out.println("String pilotCode = " + pilotCode);
            System.out.println("String pilotId = " + pilotId);

            //Записать имя пилота в results
            resultsCrudRepository.deleteAllTable();
            resultsCrudRepository.create1ParamsPilotName(pilotCode);

        }

        return "answerAddGood_page";
    }

    // Create
    @GetMapping("/CreateResultsPilotNameAll")
    public String CreateResultsPilotNameAll(@RequestParam(required = false) Model model,
                                         String PermissionCodeCountry) {
        // Вар.1 Просто создать запись с именем Пилота
        // Создать Create с одним параметром имя Пилота (ResultsCrudRepository)
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

        }

        return "answerAddGood_page";
    }

    // Update BestLap
    @GetMapping("/UpdateBestLapToFalseDefault")
    public String CreateBestLapToFalseDefault(@RequestParam(required = false) Model model,
                                        String PermissionCodeCountry) {

        //Записать дефолтное значение false в колонку bestlap
        resultsCrudRepository.UpdateResults_BestLap_ToFalseWhereIdParam(206, true);

        return "answerAddGood_page";
    }

    // Update BestLap All
    @GetMapping("/UpdateBestLapToFalseDefaultAll")
    public String UpdateBestLapToFalseDefaultAll(@RequestParam(required = false) Model model,
                                              String PermissionCodeCountry) {
        //Обойдём таблицу result c 205-224
        //Записать дефолтное значение false в колонку bestlap
        for(int i = 205; i < 225; i++){
            resultsCrudRepository.UpdateResults_BestLap_ToFalseWhereIdParam(i, false);
        }

        return "answerAddGood_page";
    }

    // Update поле type_race_id в 1 вместо null
    @GetMapping("/UpdateResults_TypeRaceID_To1WhereIdParam")
    public String UpdateResults_TypeRaceID_To1WhereIdParam(@RequestParam(required = false) Model model,
                                              String PermissionCodeCountry) {

        //Записать дефолтное значение 1 в колонку type_race_id
        resultsCrudRepository.UpdateResults_TypeRaceID_To1WhereIdParam(208, 1);

        return "answerAddGood_page";
    }

    // Update поле type_race_name в Main вместо null
    @GetMapping("/UpdateResults_TypeRaceName_ToMainWhereIdParam")
    public String UpdateResults_TypeRaceName_ToMainWhereIdParam(@RequestParam(required = false) Model model,
                                                           String PermissionCodeCountry) {

        //Записать дефолтное значение Main в колонку type_race_name
        resultsCrudRepository.UpdateResults_TypeRaceName_ToMainWhereIdParam(208, "Main");

        return "answerAddGood_page";
    }

    // Update поле type_race_id в 1 вместо null All
    @GetMapping("/UpdateResults_TypeRaceID_To1WhereIdParamAll")
    public String UpdateResults_TypeRaceID_To1WhereIdParamAll(@RequestParam(required = false) Model model,
                                                           String PermissionCodeCountry) {

        //Записать дефолтное значение 1 в колонку type_race_id
        //Обойдём таблицу result c 205-224

        for(int i = 205; i < 225; i++){
            resultsCrudRepository.UpdateResults_TypeRaceID_To1WhereIdParam(i, 1);
        }

        return "answerAddGood_page";
    }

    // Update поле type_race_name в Main вместо null All
    @GetMapping("/UpdateResults_TypeRaceName_ToMainWhereIdParamAll")
    public String UpdateResults_TypeRaceName_ToMainWhereIdParamAll(@RequestParam(required = false) Model model,
                                                                String PermissionCodeCountry) {

        //Записать дефолтное значение Main в колонку type_race_name
        for(int i = 205; i < 225; i++) {
            resultsCrudRepository.UpdateResults_TypeRaceName_ToMainWhereIdParam(i, "Main");
        }
        return "answerAddGood_page";
    }

    // Update
    @GetMapping("/UpdateResults_IdTapeRace_NameTypeRace_By_RaceAndPilots")
    public String UpdateResults_IdTapeRace_NameTypeRace_By_RaceAndPilots(@RequestParam(required = false) Model model,
                                                                        String PermissionCodeCountry) {
        // Получить выборку из Results
        // Проанализировать - заполнены ли id_type_race и name_type_race
        // если не заполнены, заполнить предопределенными значениями 1 main

        List<Results> result = resultsCrudRepository.findAllResultsDB();
        result.forEach(it3-> System.out.println(it3));
        System.out.println("result.size = " + result.size());
        int resultExists = result.size();

        int idRace = 0;
        int idPilot = 0;

        int typeRaceId = 0;
        String typeRaceName;

        if(resultExists != 0){

            //Получить id гонки и id пилота,
            //Если id гонки и id пилота не пустые,- получить значения - т.к. это уникальная запись
            idRace = result.get(0).getRaces().getId().intValue();
            idPilot = result.get(0).getPilots().getId().intValue();

            if( ! (idRace == 0 || idPilot == 0)){

            }

            // Блок type_races
            // Получить первую запись из Лист Results, затем заменить на цикл записей
            // Получить id типа гонки и имя типа гонки
            typeRaceId = result.get(0).getTypesrace().getId().intValue();
            typeRaceName = result.get(0).getType_race_namе();
            System.out.println("String typeRaceName = " + typeRaceName);

            // Если имя типа гонки или имя типа гонки null
            // то обновить запись
//
//            // Получить по имя гонки id гонки из тб races имя поля id_race
//            List<Races> resultRaces = getRacesRepository.findWhereIdRaceParam(raceName);
//            resultRaces.forEach(it3-> System.out.println(it3));
//            System.out.println("resultRaces.size = " + resultRaces.size());
//            int resultRacesExists = result.size();
//
//            if(resultRacesExists != 0){
//                raceId = resultRaces.get(0).getId().intValue();
//                System.out.println("String raceId = " + raceId);
//            }
//
//            //Записать номер гонки в results
//            resultsCrudRepository.deleteAllTable();
//            resultsCrudRepository.create2raceIdAndRaceNameParams(raceId, raceName);
//
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