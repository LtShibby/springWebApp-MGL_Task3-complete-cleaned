package com.MGL_Task3.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.MGL_Task3.controller.MGL_Endpoint_Constants;
import com.MGL_Task3.model.Review;

@Service
@Transactional
public class Review_Service_Impl implements Review_Service {

    private static RestTemplate restTemplate = new RestTemplate();
    private static final String MAIN_URI = "http://localhost:8080/MGL_Task3";

    @Override
    public void saveReview(Review review) {
	Review_Service_Impl.restTemplate.postForObject(Review_Service_Impl.MAIN_URI + MGL_Endpoint_Constants.ADD_REVIEW,
		review, Review.class);
    }

    @Override
    public Review updateReview(Review review) {
	Review updatedReview = Review_Service_Impl.restTemplate.postForObject(
		Review_Service_Impl.MAIN_URI + MGL_Endpoint_Constants.UPDATE_REVIEW, review, Review.class);
	return updatedReview;
    }

    @Override
    public Review getReview(Long id) {
	Review review = Review_Service_Impl.restTemplate.getForObject(
		Review_Service_Impl.MAIN_URI + MGL_Endpoint_Constants.FETCH_REVIEW + "?review_id=" + id, Review.class);
	return review;
    }

    @Override
    public Review getReviewAndDelete(Long id) {
	Review deletedReview = Review_Service_Impl.restTemplate.getForObject(
		Review_Service_Impl.MAIN_URI + MGL_Endpoint_Constants.DELETE_REVIEW + "?review_id=" + id, Review.class);
	if (deletedReview != null) {
	    return deletedReview;
	} else {
	    return null;
	}
    }

    @Override
    public List<Review> getReviews(Long review_game_id) {
	URI uri;
	try {
	    uri = new URI(Review_Service_Impl.MAIN_URI + MGL_Endpoint_Constants.FETCH_REVIEWS_FOR_GAME);
	    HttpEntity<?> review_game_id_http_entity = new HttpEntity<>(review_game_id.toString());
	    ResponseEntity<Review[]> reviewResponseEntity = Review_Service_Impl.restTemplate.exchange(uri,
		    HttpMethod.PUT, review_game_id_http_entity, Review[].class);
	    Review[] reviews = reviewResponseEntity.getBody();

	    List<Review> reviewList = Arrays.asList(reviews);

	    return reviewList;
	} catch (URISyntaxException e) {
	    e.printStackTrace();
	}

	return null;
    }

    @Override
    public void deleteReview(Long id) {
	Review_Service_Impl.restTemplate.put(Review_Service_Impl.MAIN_URI + MGL_Endpoint_Constants.DELETE_REVIEW, id);
    }

}