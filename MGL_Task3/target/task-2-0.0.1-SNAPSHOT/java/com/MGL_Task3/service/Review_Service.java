package com.MGL_Task3.service;

import java.util.List;

import com.MGL_Task3.model.Review;

public interface Review_Service {

    void saveReview(Review review);

    void updateReview(Review review);

    Review getReview(Long id);

    List<Review> getReviews(Long review_game_id);

    void deleteReview(Long id);

    void deleteReviews(Long review_game_id);

}
