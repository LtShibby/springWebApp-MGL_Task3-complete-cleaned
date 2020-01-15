package com.MGL_Task3.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.MGL_Task3.model.Review;

@Repository
public class ReviewDaoImpl implements ReviewDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
	return sessionFactory.getCurrentSession();
    }

    @Override
    public Review saveReview(Review review) {
	if (review != null) {
	    getCurrentSession().save(review);
	}
	return review;
    }

    @Override
    public Review updateReview(Review review) {

	CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
	CriteriaUpdate<Review> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(Review.class);
	Root<Review> rootReview = criteriaUpdate.from(Review.class);
	criteriaUpdate.set("review_body", review.getReview_body());
	criteriaUpdate.set("review_author", review.getReview_author());
	criteriaUpdate.set("review_rating", review.getReview_rating());
	criteriaUpdate.set("review_game_id", review.getReview_game_id());
	criteriaUpdate.where(criteriaBuilder.equal(rootReview.get("review_id"), review.getReview_id()));

	getCurrentSession().createQuery(criteriaUpdate).executeUpdate();

	return review;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Review> getReviews(Long review_game_id) {
	List<Review> reviews = getCurrentSession().createQuery("from Review where review_game_id = " + review_game_id)
		.list();
	return reviews;
    }

    @Override
    public Review deleteReview(Long review_id) {

	Review reviewToDelete = getReview(review_id);

	if (reviewToDelete != null) {
	    Query hqlQuery = getCurrentSession().createQuery("delete Review where review_id = :review_id");
	    hqlQuery.setParameter("review_id", review_id);
	    hqlQuery.executeUpdate();
	}

	return reviewToDelete;
    }

    @Override
    public Review getReview(Long review_id) {
	Review review = getCurrentSession().get(Review.class, review_id);
	return review;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Review> deleteReviews(Long review_game_id) {
	List<Review> reviewsToDelete = getCurrentSession()
		.createQuery("from Review where review_game_id = " + review_game_id).list();

	if (reviewsToDelete.size() > 0) {
	    Query hqlQuery = getCurrentSession().createQuery("delete Review where review_game_id = :review_game_id");
	    String review_game_id_string = String.valueOf(review_game_id);
	    hqlQuery.setParameter("review_game_id", Integer.valueOf(review_game_id_string));
	    hqlQuery.executeUpdate();
	}

	return reviewsToDelete;
    }
}
