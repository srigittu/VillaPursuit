package com.i2i.villapursuit.service;

import com.i2i.villapursuit.model.Review;

public interface ReviewManager extends GenericManager<Review, Long> {

	/**
     * {@inheritDoc}
     */
	Review saveReview(Review review);
}
