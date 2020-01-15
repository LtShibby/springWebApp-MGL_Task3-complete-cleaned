package com.MGL_Task3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @RequestMapping(value = MGL_Endpoint_Constants.SAVE_REVIEW, method = RequestMethod.POST)
    public ModelAndView saveReview(@RequestParam(value = "review_game_id") String review_game_id,
	    @ModelAttribute("review") Review review) {
	if (review.getReview_author().equals("")) {
	    review.setReview_author("anonymous");
	}
	review.setReview_game_id(Integer.valueOf(review_game_id));
	reviewManager.saveReview(review);
	return new ModelAndView("submittedReviewResult", "submittedReview", review);
    }

    @RequestMapping(value = MGL_Endpoint_Constants.UPDATE_FORM, method = RequestMethod.GET)
    public ModelAndView updateForm(@RequestParam("review_id") String review_id) {
	System.out.println("inside beginning of update form in front end");
	ModelAndView updateReviewModelAndView = new ModelAndView("reviewUpdateForm");
	Review currentReview = reviewManager.getReview(Long.valueOf(review_id));
	updateReviewModelAndView.addObject("currentReview", currentReview);
	System.out.println("inside end of update review in front end returning model and view");
	return updateReviewModelAndView;
    }

    @RequestMapping(value = MGL_Endpoint_Constants.DELETE_REVIEW, method = RequestMethod.PUT)
    public String deleteReview(@RequestParam("review_id") long review_id) {
	Review review = reviewManager.getReview(Long.valueOf(review_id));
	reviewManager.deleteReview(Long.valueOf(review_id));
	return "redirect:/reviewsForGame?review_game_id=" + review.getReview_game_id();
    }

    @RequestMapping(value = MGL_Endpoint_Constants.UPDATE_REVIEW, method = RequestMethod.POST)
    public String updateReview(@ModelAttribute Review updatedReview) {
	System.out.println("inside update review in front end");
	reviewManager.updateReview(updatedReview);
	return "redirect:/reviewsForGame?review_game_id=" + updatedReview.getReview_game_id();
    }

    @RequestMapping(value = MGL_Endpoint_Constants.REVIEWS_FOR_GAME, method = RequestMethod.GET)
    public ModelAndView reviewsForGame(@RequestParam String review_game_id) {
	ModelAndView reviewModelAndView = new ModelAndView("reviewsForGame", "command", new Review());
	List<Review> reviewsForGame = reviewManager.getReviews(Long.valueOf(review_game_id));

	reviewModelAndView.addObject("reviewsForGame", reviewsForGame);

	return reviewModelAndView;
    }

    @RequestMapping(value = MGL_Endpoint_Constants.ADD_REVIEW, method = RequestMethod.POST)
    public ModelAndView addReview(@RequestBody Review review) {
	if (review.getReview_author().equals("")) {
	    review.setReview_author("anonymous");
	}
	return new ModelAndView("submittedReviewResult", "submittedReview", review);
    }

    @RequestMapping(value = MGL_Endpoint_Constants.FETCH_REVIEWS_FOR_GAME, method = RequestMethod.PUT)
    public ResponseEntity<List<Review>> fetchReviewsForGame(@RequestBody String review_game_id) {
	return new ResponseEntity<>(reviewManager.getReviews(Long.valueOf(review_game_id)), HttpStatus.OK);
    }

}
