package com.javamaster.dao;

import com.javamaster.repository.UpdateCountriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateCountryFromDB {

    @Autowired
    private final UpdateCountriesRepository updateCountriesRepository;

    public UpdateCountryFromDB(UpdateCountriesRepository updateCountriesRepository) {
        this.updateCountriesRepository = updateCountriesRepository;
    }

    public void updateCountryCodeParametr(String codeCountry) {
        updateCountriesRepository.updateWhereCodeCountryParam(codeCountry);
    }
}