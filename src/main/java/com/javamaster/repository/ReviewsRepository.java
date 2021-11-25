package com.javamaster.repository;

import com.javamaster.entity.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewsRepository extends JpaRepository<Reviews, Long> {

    List<Reviews> findReviewsByGrade(int grade);

}

