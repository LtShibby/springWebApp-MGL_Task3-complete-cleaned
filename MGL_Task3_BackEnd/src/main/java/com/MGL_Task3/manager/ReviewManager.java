package com.MGL_Task3.manager;

import java.util.List;
import java.util.Optional;

import com.MGL_Task3.model.Review;

public interface ReviewManager {

    Review saveReview(Review review);

    void updateReview(Review review);

    Optional<Review> getReview(Long id);

    List<Review> getReviews(Long review_game_id);

    void deleteReview(Long id);

    Review getReviewForUpdate(Long review_id);

}
