package com.MGL_Task3.manager;

import java.util.List;

import com.MGL_Task3.model.Review;

public interface ReviewManager {

    void saveReview(Review review);

    void updateReview(Review review);

    Review getReview(Long id);

    List<Review> getReviews(Long review_game_id);

    Review deleteReview(Long id);

    void deleteReviews(Long game_id);

}
