package com.MGL_Task3.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.MGL_Task3.controller.MGL_Endpoint_Constants;
import com.MGL_Task3.dao.ReviewDao;
import com.MGL_Task3.model.Review;

@Service
@Transactional
public class Review_Service_Impl implements Review_Service {

    private static RestTemplate restTemplate = new RestTemplate();
    private static final String MAIN_URI = "http://localhost:8080/MGL_Task3";

    @Autowired
    private ReviewDao reviewDao;

    @Override
    public void saveReview(Review review) {
	System.out.println("before BACK END CALL FOR SAVE REVIEW.. Review to save: " + review.toString());
	Review savedReview = Review_Service_Impl.restTemplate
		.postForObject(Review_Service_Impl.MAIN_URI + MGL_Endpoint_Constants.ADD_REVIEW, review, Review.class);
//		 .putForLocation(Review_Service_Impl.MAIN_URI + MGL_Endpoint_Constants.SAVE_REVIEW, review);
	System.out.println("after BACK END CALL FOR SAVE REVIEW.. Saved Review: " + savedReview.toString());
    }

    @Override
    public void updateReview(Review review) {
	System.out.println("before BACK END CALL FOR UPDATE REVIEW.. Review to save: " + review.toString());
	URI updateUri;
	try {
	    updateUri = new URI(Review_Service_Impl.MAIN_URI + MGL_Endpoint_Constants.UPDATE_REVIEW);
	    RequestEntity<?> reviewRequestEntity = new RequestEntity(review, HttpMethod.POST, updateUri);
//	    Review_Service_Impl.restTemplate.exchange(reviewRequestEntity, Review.class);
	    Review_Service_Impl.restTemplate.postForObject(updateUri, review, Review.class);
	    // .exchange(reviewRequestEntity, Review.class);
	    System.out.println("after BACK END CALL FOR UPDATE REVIEW.. Saved Review: " + review.toString());
	} catch (URISyntaxException e) {
	    e.printStackTrace();
	}

    }

    @Override
    public Review getReview(Long id) {
	return reviewDao.getReview(id);
    }

    @Override
    public List<Review> getReviews(Long review_game_id) {
	System.out.println("Inside listReviews in Review Service in Front end review_game_id: " + review_game_id);

	URI uri;
	try {
	    uri = new URI(Review_Service_Impl.MAIN_URI + MGL_Endpoint_Constants.FETCH_REVIEWS_FOR_GAME);
	    HttpEntity<?> review_game_id_http_entity = new HttpEntity<>(review_game_id.toString());
	    ResponseEntity<Review[]> reviewResponseEntity = Review_Service_Impl.restTemplate.exchange(uri,
		    HttpMethod.PUT, review_game_id_http_entity, Review[].class);
	    Review[] reviews = reviewResponseEntity.getBody();

	    List<Review> reviewList = Arrays.asList(reviews);

	    System.out.println(reviewList.toString());

	    return reviewList;
	} catch (URISyntaxException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	return null;
    }

    @Override
    public void deleteReview(Long id) {
	System.out.println("before BACK END CALL FOR delete REVIEW: " + Review_Service_Impl.MAIN_URI
		+ MGL_Endpoint_Constants.DELETE_REVIEW + " " + id);
	Review_Service_Impl.restTemplate.put(Review_Service_Impl.MAIN_URI + MGL_Endpoint_Constants.DELETE_REVIEW, id);
    }

    @Override
    public void deleteReviews(Long review_game_id) {
	reviewDao.deleteReviews(review_game_id);
    }

}