package com.javamaster.repository;

import com.javamaster.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BooksRepository extends JpaRepository<Books, Long> {

    List<Books> findAllByName(String name);

    @Query(value = "select * books where name like '%bunin%'", nativeQuery = true)
    List<Books> findWhereNameBunin();
}
