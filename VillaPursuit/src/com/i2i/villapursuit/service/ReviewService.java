// Copyright (C) 2015 Ideas2IT, Inc.
// All rights reserved

package com.i2i.villapursuit.service;

import java.util.List;

import com.i2i.villapursuit.dao.ReviewDao;
import com.i2i.villapursuit.exception.VillaPursuitException;
import com.i2i.villapursuit.model.Review;

/**
 * 
 * <p>
 * Service which gets request from controller.
 * Permits to perform advertisement review insertion and review retrieval operations.
 * According to URL mapping
 * </p>
 * 
 * @author Team #3
 *
 * @created 09/09/16 
 *
 */
public class ReviewService {
    private ReviewDao reviewDao = new ReviewDao();
    
    /**
     * <p>
     * Method which gets request from controller.
     * Perform validations to insert review details into database.
     * </p>
     * @param review
     *     Object contains review details to be inserted into database.
     * @param advertisementId
     *     Contains Advertisement Id.
     * @param userId
     *     Contains user Id.
     * @return string
     *     Contains status string.
     * @throws VillaPursuitException
     *     If there is failed or interrupted database operations.
     */
    public String addAdvertisementReview(Review review, int advertisementId, int userId) throws VillaPursuitException {
    	reviewDao.insertReview(review, advertisementId, userId);
        return "advertisement successfully posted";
    }
    
    /**
     * <p>
     * Method which gets request from controller.
     * Perform validations to retrieve advertisement details from database.
     * </p>
     * @return list
     *     Contains list of advertisements
     * @throws VillaPursuitException
     *     If there is failed or interrupted database operations.
     */
    public List<Review> retriveAllReviews() throws VillaPursuitException {
        return reviewDao.retriveAllReviews();
    } 
}
