package com.javamaster.dao;

import com.javamaster.entity.Cities;
import com.javamaster.entity.Countries;
import com.javamaster.repository.GetCitiesRepository;
import com.javamaster.repository.GetCountriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCityFromDB {

    @Autowired
    private final GetCitiesRepository getCitiesRepository;

    public GetCityFromDB(GetCitiesRepository getCitiesRepository){
        this.getCitiesRepository = getCitiesRepository;
    }

    public List<Cities> findAllCitiesDB(){
        return getCitiesRepository.findAllCitiesDB();
    }
}