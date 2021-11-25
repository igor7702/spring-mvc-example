package com.javamaster.service;

import com.javamaster.entity.Books;
import com.javamaster.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private final BooksRepository booksRepository;

    public BookService(BooksRepository booksRepository){
        this.booksRepository = booksRepository;
    }

    public List<Books> findAllByName(String name){
        return booksRepository.findAllByName(name);
    }

    public List<Books> findAllByName(){
        return booksRepository.findAllByName("Kosmos");
    }

    public List<Books> findWhereNameBunin(){
        return booksRepository.findWhereNameBunin();
    }
}
