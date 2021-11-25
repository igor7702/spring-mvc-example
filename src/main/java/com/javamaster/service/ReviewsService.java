package com.javamaster.service;

import com.javamaster.entity.Reviews;
import com.javamaster.repository.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewsService {

    @Autowired
    private final ReviewsRepository reviewsRepository;

    public ReviewsService(ReviewsRepository reviewsRepository) {
        this.reviewsRepository = reviewsRepository;
    }

    public void createReviews(Reviews reviews) {
        reviewsRepository.save(reviews);
    }
}
