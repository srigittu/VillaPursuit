package com.i2i.villapursuit.dao;

import com.i2i.villapursuit.model.Review;

/**
 * Review Data Access Object (GenericDao) interface.
 *
 * @author Team #3
 */
public interface ReviewDao extends GenericDao<Review, Long> {

	/**
     * Saves a advertisement's information.
     * @param advertisement the object to be saved
     * @return the persisted advertisement object
     */
	Review saveReview(Review review);
}
