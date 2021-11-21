package com.javamaster.dao;

import com.javamaster.repository.DeleteCountriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeleteCountryFromDB {

    @Autowired
    private final DeleteCountriesRepository deleteCountriesRepository;

    public DeleteCountryFromDB(DeleteCountriesRepository deleteCountriesRepository){
        this.deleteCountriesRepository = deleteCountriesRepository;
    }

    public void deleteCountry643() {
        deleteCountriesRepository.deleteWhereCodeCountryIs643();
    }

    public void deleteCountryCodeParametr(String codeCountry) {
        deleteCountriesRepository.deleteWhereCodeCountryParametr(codeCountry);
    }

}