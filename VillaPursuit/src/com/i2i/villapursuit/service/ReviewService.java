/**
 * @author Team #3
 *
 * @created 12/09/16 
 */
package com.i2i.villapursuit.service;

import java.util.List;

import com.i2i.villapursuit.dao.ReviewDao;
import com.i2i.villapursuit.exception.VillaPursuitException;
import com.i2i.villapursuit.model.Review;

public class ReviewService {
    private ReviewDao reviewDao = new ReviewDao();
    
    public String addAdvertisementReview(Review review, int advertisementId, int userId) throws VillaPursuitException {
    	reviewDao.insertReview(review, advertisementId, userId);
        return "advertisement successfully posted";
    }
    
    public List<Review> retriveAllReviews() throws VillaPursuitException {
        return reviewDao.retriveAllReviews();
    } 
    



}
