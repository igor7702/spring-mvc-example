package com.javamaster.controller;

import com.javamaster.entity.Address;
import com.javamaster.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javamaster.entity.Address;
import com.javamaster.entity.Users;
import com.javamaster.service.AddressService;
import com.javamaster.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class AddAddressUserInfoController {
    @Autowired
    private UserService userService;

    @GetMapping("/addAddressUserInfo")
    public String home(@RequestParam(required = false) String cityAddressUser,
                       Model model, String streetAddressUser, String homeNumberAddressUser,
                       String nameUser, String emailUser) {

        cityAddressUser="Pskov";
        streetAddressUser="Bolshay Street";
        homeNumberAddressUser="21";
        nameUser="Igor1";
        emailUser="igor@mail.ru";

        Address address = new Address();
        address.setCity(cityAddressUser);
        address.setHomeNumber(homeNumberAddressUser);
        address.setStreet(streetAddressUser);

        Users users = new Users();
        users.setAddress(address);
        users.setEmail(emailUser);
        users.setName(nameUser);
        userService.createUsers(users);

        return "answerAddRaceInfo_page.html"; // используется общий темплейт о добавлении записи
    }
}