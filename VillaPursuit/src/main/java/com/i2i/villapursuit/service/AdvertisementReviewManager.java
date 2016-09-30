package com.i2i.villapursuit.service;

import java.util.List;

import com.i2i.villapursuit.model.AdvertisementReview;
import com.i2i.villapursuit.model.User;
/**
 * Business Service Interface to handle communication between web and
 * persistence layer.
 *
 * @author Team #3
 */
public interface AdvertisementReviewManager extends GenericManager<AdvertisementReview, Long> {
    /**
     * {@inheritDoc}
     */
    List<AdvertisementReview> getAdvertisementReviews();
    
    /**
     * {@inheritDoc}
     */
    AdvertisementReview saveAdvertisementReview(AdvertisementReview advertisementReview, Long advertisementId, User user);
    
    /**
     * {@inheritDoc}
     */
    void removeAdvertisementReviewById(Long advertisementId);
    
    /**
     * {@inheritDoc}
     */
    AdvertisementReview getAdvertisementReviewById(Long advertisementId);
}
