package com.i2i.villapursuit.dao;

import java.util.List;

import com.i2i.villapursuit.exception.VillaPursuitException;
import com.i2i.villapursuit.model.Advertisement;
import com.i2i.villapursuit.model.Review;

/**
 * Review Data Access Object (GenericDao) interface.
 *
 * @author Team #3
 */
public interface ReviewDao extends GenericDao<Review, Long> {

    /**
     * Saves a advertisement's information.
     * 
     * @param advertisement
     *            the object to be saved
     * @return the persisted advertisement object
     * @throws VillaPursuitException
     *             If there is failed or interrupted when save all reviews or
     *             when connection fails.
     */
    Review saveReview(Review review) throws VillaPursuitException;

    /**
     * Gets a list of Reviews based on advertisement id.
     *
     * @return List populated list of reviews.\
     * @throws VillaPursuitException
     *             If there is failed or interrupted when get all reviews or
     *             when connection fails.
     */
    List<Review> getAdvertisementReviews(Long advertisementId) throws VillaPursuitException;
}
