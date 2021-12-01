package com.javamaster.dao;

import com.javamaster.repository.UpdateCityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateCityFromDB {

    @Autowired
    private final UpdateCityRepository updateCityRepository;

    public UpdateCityFromDB(UpdateCityRepository updateCityRepository) {
        this.updateCityRepository = updateCityRepository;
    }

    public void updateCityCodeParametr(int codeCity, String nameCity) {
        updateCityRepository.updateWhereCodeCityParam(codeCity, nameCity);
    }
}