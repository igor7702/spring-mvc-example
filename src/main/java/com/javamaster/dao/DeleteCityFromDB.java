package com.javamaster.dao;

import com.javamaster.repository.DeleteCitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteCityFromDB {

    @Autowired
    private final DeleteCitiesRepository deleteCitiesRepository;

    public DeleteCityFromDB(DeleteCitiesRepository deleteCitiesRepository){
        this.deleteCitiesRepository = deleteCitiesRepository;
    }

    public void deleteCitiesById(Long idCity) {
        deleteCitiesRepository.deleteById(idCity);
    }

}