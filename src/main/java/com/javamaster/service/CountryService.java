package com.javamaster.service;

import com.javamaster.entity.Countries;
import com.javamaster.repository.CountriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private final CountriesRepository countriesRepository;

    public CountryService(CountriesRepository countriesRepository){
        this.countriesRepository = countriesRepository;
    }

    public void createCountry(Countries countries) {
        countriesRepository.save(countries);
    }

    public List<Countries> findAll(){
        return countriesRepository.findAll();
    }

    public Countries findById(Long countryId){
        return countriesRepository.findById(countryId).orElse(null);
    }

//    public List<Countries> findAllByName(String name){
//        return countriesRepository.findAllByName(name);
//    }

    public List<Countries> findWhereNameCountryIsRussia(){
        return countriesRepository.findWhereNameCountryIsRussia();
    }
}