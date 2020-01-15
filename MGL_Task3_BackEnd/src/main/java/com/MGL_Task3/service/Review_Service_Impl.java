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
	System.out.println("About to call ReviewRepository.save for review in back end");
	System.out.println();
	return reviewRepository.save(review);
    }

    @Override
    public void updateReview(Review review) {
	System.out.println("About to call ReviewRepository.save for update for review in back end");
	System.out.println();
	reviewRepository.save(review);
    }

    @Override
    public Optional<Review> getReview(Long id) {
	System.out.println("$$$$$$$$$$$inside get review in backend");
	System.out.println();
	Optional<Review> fetchedReview = reviewRepository.findById(id);
	System.out.println("&&&&&&&&&&& fetched review: " + fetchedReview.toString());
	return reviewRepository.findById(id);
    }

    @Override
    public List<Review> getReviews(Integer review_game_id) {
	System.out.println("About to call ReviewRepository.findByReviewGameId for review in back end");
	System.out.println();
	System.out.println(reviewRepository.findByReviewGameId(review_game_id));
	return reviewRepository.findByReviewGameId(review_game_id);
    }

    @Override
    public Review getReviewForUpdate(Long review_id) {
	System.out.println("About to call ReviewRepository.findByReviewGameId for review in back end");
	System.out.println();
	Review review = reviewRepository.getOne(review_id);
	System.out.println("Review from getReviewForUpdate: " + review);
	return review;
    }

    @Override
    public void deleteReview(Long id) {
	System.out.println("About to call ReviewRepository.delete for review in back end");
	System.out.println();
	reviewRepository.deleteById(id);
    }

}
