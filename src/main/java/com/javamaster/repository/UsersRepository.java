package com.javamaster.repository;

import com.javamaster.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {

    List<Users> findAllByName(String name);//просто правильное название метода даст возможность
    //избежать запросов на SQL

    @Query("select u from Users u where u.email like '%@gmail.com%'")//или написать
        //собственный запрос на языке похожем на SQL
    List<Users> findWhereEmailIsGmail();

    @Query(value = "select * from users where name like '%smith%'", nativeQuery = true)
        //или - можно написать запрос на чистом SQL
    List<Users> findWhereNameStartsFromSmith();
}
