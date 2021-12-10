package com.javamaster.dao;

import com.javamaster.repository.SetRaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SetHbRaceToDB {

    @Autowired
    private final SetRaceRepository setRaceRepository;

    public SetHbRaceToDB(SetRaceRepository setRaceRepository){
        this.setRaceRepository = setRaceRepository;
    }

    public void createRaceAllParams(String weekRace, String yearRace, String nameCountry, String nameCity,
                                    long idCountry, long idCity, String idRace) {
        setRaceRepository.createRaceAllParams(weekRace,yearRace, nameCountry, nameCity, idCountry,
                idCity, idRace);
    }

}


