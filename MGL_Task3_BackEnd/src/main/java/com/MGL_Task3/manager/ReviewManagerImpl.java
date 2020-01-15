package com.MGL_Task3.manager;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MGL_Task3.model.Review;
import com.MGL_Task3.service.Review_Service;

@Service
public class ReviewManagerImpl implements ReviewManager {

    @Autowired
    private Review_Service reviewService;

    @Override
    public Review saveReview(Review review) {
	return reviewService.saveReview(review);
    }

    @Override
    public void updateReview(Review review) {
	reviewService.updateReview(review);
    }

    @Override
    public Optional<Review> getReview(Long review_id) {
	return reviewService.getReview(review_id);
    }

    @Override
    public List<Review> getReviews(Long review_game_id) {
	return reviewService.getReviews(Integer.valueOf(review_game_id.toString()));
    }

    @Override
    public void deleteReview(Long id) {
	reviewService.deleteReview(id);
    }

    @Override
    public Review getReviewForUpdate(Long review_id) {
	return reviewService.getReviewForUpdate(review_id);
    }

}