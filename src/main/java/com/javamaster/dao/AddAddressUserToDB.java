package com.javamaster.dao;

import com.javamaster.entity.Address;
import com.javamaster.entity.Users;
import com.javamaster.service.AddressService;
import com.javamaster.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

public class AddAddressUserToDB {

    @Autowired
    private UserService userService;

    Address address = new Address();

    public void setAddress(Address address) {
        this.address = address;
        this.address.setCity("Novgorod");
        this.address.setHomeNumber("8");
        this.address.setStreet("Ozernay Street");
    }

    Users users = new Users();

    public void setUsers(Users users) {
        this.users = users;
        this.users.setAddress(address);
		this.users.setEmail("someEmail@novgorod.ru");
		this.users.setName("Ivan");
		this.userService.createUsers(users);
    }

//		address.setCity("Pskov");
//		address.setHomeNumber("7");
//		address.setStreet("Flower Street");

//		users.setAddress(address);
//		users.setEmail("someEmail@list.ru");
//		users.setName("Petr");
//		userService.createUsers(users);
}
