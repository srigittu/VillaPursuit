package com.i2i.villapursuit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i2i.villapursuit.dao.ReviewDao;
import com.i2i.villapursuit.dao.RoleDao;
import com.i2i.villapursuit.model.Review;
import com.i2i.villapursuit.service.ReviewManager;

/**
 * Implementation of ReviewManager interface.
 *
 * @author Team #3
 */
@Service("reviewManager")
public class ReviewManagerImpl extends GenericManagerImpl<Review, Long> implements ReviewManager {
    ReviewDao reviewDao;
    
    @Autowired
    public ReviewManagerImpl(ReviewDao reviewDao) {
        super(reviewDao);
        this.reviewDao = reviewDao;
    }
	/**
     * {@inheritDoc}
     */
	public Review saveReview(Review review) {
		System.out.println("inside add review serviceimpl");
		return reviewDao.saveReview(review);
	}
}
