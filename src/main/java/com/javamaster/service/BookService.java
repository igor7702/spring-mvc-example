package com.javamaster.service;

import com.javamaster.entity.Books;
import com.javamaster.repository.GetCitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private final GetCitiesRepository getCitiesRepository;

    public BookService(GetCitiesRepository getCitiesRepository){
        this.getCitiesRepository = getCitiesRepository;
    }

//    public List<Books> findAllByName(String name){
//        return getCitiesRepository.findAllByName(name);
//    }
//
//    public List<Books> findAllByName(){
//        return getCitiesRepository.findAllByName("Kosmos");
//    }
//
//    public List<Books> findWhereNameBunin(){
//        return getCitiesRepository.findWhereNameBunin();
//    }
}
