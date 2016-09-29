package com.i2i.villapursuit.service;

import java.util.List;

import com.i2i.villapursuit.exception.VillaPursuitException;
import com.i2i.villapursuit.model.Review;

public interface ReviewManager extends GenericManager<Review, Long> {

    /**
     * {@inheritDoc}
     */
    Review saveReview(Review review) throws VillaPursuitException;

    /**
     * {@inheritDoc}
     */
    List<Review> getAdvertisementReviews(Long advertisementId) throws VillaPursuitException;
}
