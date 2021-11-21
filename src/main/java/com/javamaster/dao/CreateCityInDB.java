package com.javamaster.dao;

import com.javamaster.repository.CreateCityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCityInDB {

    @Autowired
    private final CreateCityRepository createCityRepository;

    public CreateCityInDB(CreateCityRepository createCityRepository){
        this.createCityRepository = createCityRepository;
    }

    public void createCityNameParametr(String nameCity) {
        createCityRepository.createCityNameParametr(nameCity);
    }

}


