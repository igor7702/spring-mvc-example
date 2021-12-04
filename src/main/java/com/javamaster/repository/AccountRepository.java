package com.javamaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.javamaster.model.Account;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    int countByUser_IdIn(List ids);

}