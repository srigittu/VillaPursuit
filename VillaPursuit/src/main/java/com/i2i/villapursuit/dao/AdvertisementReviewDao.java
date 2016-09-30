package com.i2i.villapursuit.dao;

import java.util.List;

import com.i2i.villapursuit.model.AdvertisementReview;
import com.i2i.villapursuit.model.User;

/**
 * AdvertisementReviewReview Data Access Object (GenericDao) interface.
 *
 * @author Team #3
 */
public interface AdvertisementReviewDao extends GenericDao<AdvertisementReview, Long> {
    /**
     * Gets a list of AdvertisementReviews.
     *
     * @return List populated list of advertisementReviews
     */
    List<AdvertisementReview> getAdvertisementReviews();
    
    /**
     * Saves a advertisementReview's information.
     * 
     * @param advertisementReview the object to be saved
     * @param user who posted the review for an advertisement
     * @param advertisementId the advertisement
     * @return the persisted advertisementReview object
     */
    AdvertisementReview saveAdvertisementReview(AdvertisementReview advertisementReview, Long advertisementId, User user);
    
    /**
     * Removes a advertisementReview from the database by advertisementReviewId
     * 
     * @param advertisementReviewId the advertisementReview's id
     */
    void removeAdvertisementReviewById(Long advertisementReviewId);

    /**
     * Retrieves the particular AdvertisementReview associated with the advertisementReviewId
     * 
     * @param advertisementReviewId the advertisementReview's id
     * @return the particular advertisementReview.
     */
    AdvertisementReview getAdvertisementReviewById(Long advertisementReviewId);
}
