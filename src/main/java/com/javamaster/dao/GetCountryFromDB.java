package com.javamaster.dao;

import com.javamaster.entity.Countries;
import com.javamaster.repository.GetCountriesRepository;
import com.javamaster.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCountryFromDB {

    @Autowired
    private final GetCountriesRepository getCountriesRepository;

    @Autowired
    private UserService userService;

    public GetCountryFromDB(GetCountriesRepository getCountriesRepository){
        this.getCountriesRepository = getCountriesRepository;
    }

    public List<Countries> findWhereCodeCountryParam(String codeCountry){
        return getCountriesRepository.findWhereCodeCountryParam(codeCountry);
    }

}