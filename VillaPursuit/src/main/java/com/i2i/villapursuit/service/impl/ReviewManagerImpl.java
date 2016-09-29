package com.i2i.villapursuit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i2i.villapursuit.dao.ReviewDao;
import com.i2i.villapursuit.dao.RoleDao;
import com.i2i.villapursuit.exception.VillaPursuitException;
import com.i2i.villapursuit.model.Advertisement;
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

    /**
     * Constructor of the method ReviewManagerImpl.
     * 
     * @param reviewDao
     *            Object of review dao class.
     * @throws VillaPursuitException
     *             If there is failed or interrupted database operation or
     *             hibernate connections.
     */
    @Autowired
    public ReviewManagerImpl(ReviewDao reviewDao) throws VillaPursuitException {
        super(reviewDao);
        this.reviewDao = reviewDao;
    }

    /**
     * Method which performs validations to insert an review for an
     * advertisement.
     * 
     * @throws VillaPursuitException
     *             If there is failed or interrupted database operation or
     *             hibernate connections.
     */
    public Review saveReview(Review review) throws VillaPursuitException {
        System.out.println("inside add review serviceimpl");
        return reviewDao.saveReview(review);
    }

    /**
     * Method which gets request to get all inactive advertisements.
     * 
     * @throws VillaPursuitException
     *             If there is failed or interrupted database operation or
     *             hibernate connections.
     */
    public List<Review> getAdvertisementReviews(Long advertisementId) throws VillaPursuitException {
        return reviewDao.getAdvertisementReviews(advertisementId);
    }
}
