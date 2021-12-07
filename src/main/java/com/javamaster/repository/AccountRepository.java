package com.javamaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.javamaster.entity.Account;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    int countByUser_IdIn(List ids);

}