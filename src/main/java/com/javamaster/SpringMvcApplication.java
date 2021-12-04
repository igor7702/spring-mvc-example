package com.javamaster;

import com.javamaster.dao.GetCountryFromDB;
import com.javamaster.dao.UpdateCityFromDB;
import com.javamaster.dao.GetCityFromDB;
import com.javamaster.dao.SetHbRaceToDB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javamaster.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling

public class SpringMvcApplication {

    @Autowired
    private UserService userService;

    @Autowired
    private GetCountryFromDB getCountryFromDB;

    @Autowired
    private GetCityFromDB getCityFromDB;
    @Autowired
    private UpdateCityFromDB updateCityFromDB;

    @Autowired
    private SetHbRaceToDB setHbRaceToDB;

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    private void testJpaMethods(){

//        userService.findAll().forEach(it-> System.out.println(it));
//        userService.findAllByName("Smith").forEach(it-> System.out.println(it));
//        userService.findWhereEmailIsGmail().forEach(it-> System.out.println(it));
//        userService.findWhereNameStartsFromSmith().forEach(it-> System.out.println(it));

//        getCountryFromDB.findWhereCodeCountryParam("643").forEach(it->System.out.println(it));
//        Countries countries = getCountryFromDB.findWhereCodeCountryParam("643").get(0);
//        String nameCountry=countries.getName_country();
//        System.out.println(nameCountry);

//        getCityFromDB.findAllCitiesDB().forEach(it->System.out.println(it));
//        updateCityFromDB.updateCityCodeParametr(1,"Noname2");

    }
}