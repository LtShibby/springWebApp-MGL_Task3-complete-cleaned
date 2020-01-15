package com.MGL_Task3.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MGL_Task3.model.Review;
import com.MGL_Task3.service.Review_Service;

@Service
public class ReviewManagerImpl implements ReviewManager {

    @Autowired
    private Review_Service reviewService;

    @Override
    public void saveReview(Review review) {
	reviewService.saveReview(review);
    }

    @Override
    public void updateReview(Review review) {
	reviewService.updateReview(review);
    }

    @Override
    public Review getReview(Long review_id) {
	return reviewService.getReview(review_id);
    }

    @Override
    public List<Review> getReviews(Long review_game_id) {
	return reviewService.getReviews(review_game_id);
    }

    @Override
    public Review deleteReview(Long id) {
	return reviewService.getReviewAndDelete(id);
    }

    @Override
    public void deleteReviews(Long review_game_id) {
	reviewService.deleteReviews(review_game_id);
    }

}