package com.MGL_Task3.service;

import java.util.List;
import java.util.Optional;

import com.MGL_Task3.model.Review;

public interface Review_Service {

    Review saveReview(Review review);

    void updateReview(Review review);

    Optional<Review> getReview(Long id);

    List<Review> getReviews(Integer review_game_id);

    void deleteReview(Long id);

    Review getReviewForUpdate(Long review_game_id);

}
