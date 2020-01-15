package com.MGL_Task3.dao;

import java.util.List;

import com.MGL_Task3.model.Review;

public interface ReviewDao {

    Review saveReview(Review review);

    Review updateReview(Review review);

    Review getReview(Long id);

    List<Review> getReviews(Long review_game_id);

    Review deleteReview(Long id);

    List<Review> deleteReviews(Long review_game_id);

}