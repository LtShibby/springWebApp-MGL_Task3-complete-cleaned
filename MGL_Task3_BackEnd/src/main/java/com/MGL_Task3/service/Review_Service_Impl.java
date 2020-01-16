package com.MGL_Task3.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MGL_Task3.model.Review;
import com.MGL_Task3.repository.ReviewRepository;

@Service
@Transactional
public class Review_Service_Impl implements Review_Service {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Review saveReview(Review review) {
	return reviewRepository.save(review);
    }

    @Override
    public void updateReview(Review review) {
	reviewRepository.save(review);
    }

    @Override
    public Optional<Review> getReview(Long id) {
	return reviewRepository.findById(id);
    }

    @Override
    public List<Review> getReviews(Integer review_game_id) {
	return reviewRepository.findByReviewGameId(review_game_id);
    }

    @Override
    public Review getReviewForUpdate(Long review_id) {
	Review review = reviewRepository.getOne(review_id);
	return review;
    }

    @Override
    public void deleteReview(Long id) {
	reviewRepository.deleteById(id);
    }

}
