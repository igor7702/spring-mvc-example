package com.javamaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javamaster.entity.Address;
import com.javamaster.entity.Users;
import com.javamaster.service.AddressService;
import com.javamaster.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringMvcApplication {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    private void testJpaMethods(){

//        Address address = new Address();
//        address.setCity("Pskov");
//        address.setHomeNumber("9");
//        address.setStreet("Flower Street");
//
//        Users users = new Users();
//        users.setAddress(address);
//        users.setEmail("someEmail@list.ru");
//        users.setName("Petr");
//        userService.createUsers(users);

        userService.findAll().forEach(it-> System.out.println(it));

        userService.findAllByName("Smith").forEach(it-> System.out.println(it));

        userService.findWhereEmailIsGmail().forEach(it-> System.out.println(it));

        userService.findWhereNameStartsFromSmith().forEach(it-> System.out.println(it));
    }
}