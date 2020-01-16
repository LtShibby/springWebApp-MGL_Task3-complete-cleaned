package com.MGL_Task3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.MGL_Task3.manager.ReviewManager;
import com.MGL_Task3.model.Review;

@Controller
public class Review_Controller {

    @Autowired
    private ReviewManager reviewManager;

    @RequestMapping(value = MGL_Endpoint_Constants.SAVE_REVIEW, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveReview(@RequestBody Review review) {
	return new ResponseEntity<>(reviewManager.saveReview(review), HttpStatus.OK);
    }

    @RequestMapping(value = MGL_Endpoint_Constants.UPDATE_FORM, method = RequestMethod.GET)
    public Review updateForm(@RequestParam("review_id") String review_id) {
	Review review = reviewManager.getReviewForUpdate(Long.valueOf(review_id));
	return review;
    }

    @RequestMapping(value = MGL_Endpoint_Constants.DELETE_REVIEW, method = RequestMethod.GET)
    public ResponseEntity<?> deleteReview(@RequestParam("review_id") String review_id) {
	Optional<Review> reviewToDelete = reviewManager.getReview(Long.valueOf(review_id));
	reviewManager.deleteReview(Long.valueOf(review_id));
	return new ResponseEntity<>(reviewToDelete, HttpStatus.OK);
    }

    @RequestMapping(value = MGL_Endpoint_Constants.UPDATE_REVIEW, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateReview(@RequestBody Review review) {
	return new ResponseEntity<>(reviewManager.saveReview(review), HttpStatus.OK);
    }

    @RequestMapping(value = MGL_Endpoint_Constants.REVIEWS_FOR_GAME, method = RequestMethod.GET)
    public ModelAndView reviewsForGame(@RequestParam String review_game_id) {
	ModelAndView reviewModelAndView = new ModelAndView("reviewsForGame", "command", new Review());
	List<Review> reviewsForGame = reviewManager.getReviews(Long.valueOf(review_game_id));

	reviewModelAndView.addObject("reviewsForGame", reviewsForGame);

	return reviewModelAndView;
    }

    @RequestMapping(value = MGL_Endpoint_Constants.ADD_REVIEW, method = RequestMethod.POST)
    public ResponseEntity<Review> addReview(@RequestBody Review review) {
	if (review.getReview_author().equals("")) {
	    review.setReview_author("anonymous");
	}
	return new ResponseEntity<>(reviewManager.saveReview(review), HttpStatus.OK);
    }

    @RequestMapping(value = MGL_Endpoint_Constants.FETCH_REVIEWS_FOR_GAME, method = RequestMethod.PUT)
    public ResponseEntity<List<Review>> fetchReviewsForGame(@RequestBody String review_game_id) {
	return new ResponseEntity<>(reviewManager.getReviews(Long.valueOf(review_game_id)), HttpStatus.OK);
    }

    @RequestMapping(value = MGL_Endpoint_Constants.FETCH_REVIEW, method = RequestMethod.GET)
    public ResponseEntity<Review> fetchReview(@RequestParam String review_id) {
	return new ResponseEntity<>(reviewManager.getReviewForUpdate(Long.valueOf(review_id)), HttpStatus.OK);
    }

}
