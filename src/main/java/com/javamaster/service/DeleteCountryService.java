package com.javamaster.service;

import com.javamaster.entity.Countries;
import com.javamaster.repository.DeleteCountriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeleteCountryService {

    @Autowired
    private final DeleteCountriesRepository deleteCountriesRepository;

    public DeleteCountryService(DeleteCountriesRepository deleteCountriesRepository){
        this.deleteCountriesRepository = deleteCountriesRepository;
    }

    public void deleteCountry(Countries countries) {
        deleteCountriesRepository.deleteWhereCodeCountryIs643();
    }
}