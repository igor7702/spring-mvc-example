package com.javamaster.dao;

import com.javamaster.entity.Races;
import com.javamaster.repository.GetRacesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetHbRacesFromDB {

    @Autowired
    private final GetRacesRepository getRacesRepository;

    public GetHbRacesFromDB(GetRacesRepository getRacesRepository){
        this.getRacesRepository = getRacesRepository;
    }

    public List<Races> findAllRacesDB(){
        return getRacesRepository.findAllRacesDB();
    }
}