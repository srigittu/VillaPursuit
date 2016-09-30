package com.i2i.villapursuit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i2i.villapursuit.dao.AdvertisementReviewDao;
import com.i2i.villapursuit.model.AdvertisementReview;
import com.i2i.villapursuit.model.User;
import com.i2i.villapursuit.service.AdvertisementReviewManager;

/**
 * Implementation of AdvertisementReviewManager interface.
 *
 * @author Team #3
 */
@Service("advertisementReviewManager")
public class AdvertisementReviewManagerImpl extends GenericManagerImpl<AdvertisementReview, Long> implements AdvertisementReviewManager{
    AdvertisementReviewDao advertisementReviewDao;

    @Autowired
    public AdvertisementReviewManagerImpl(AdvertisementReviewDao advertisementReviewDao) {
        super(advertisementReviewDao);
        this.advertisementReviewDao = advertisementReviewDao;
    }
    
    /**
     * {@inheritDoc}
     */
    public List<AdvertisementReview> getAdvertisementReviews() {
        return advertisementReviewDao.getAdvertisementReviews();
    }

    /**
     * {@inheritDoc}
     */
    public AdvertisementReview saveAdvertisementReview(AdvertisementReview advertisementReview, Long advertisementId, User user) {
        return advertisementReviewDao.saveAdvertisementReview(advertisementReview, advertisementId, user);
    }

    /**
     * {@inheritDoc}
     */
    public void removeAdvertisementReviewById(Long advertisementId) {
        advertisementReviewDao.removeAdvertisementReviewById(advertisementId);
        
    }

    /**
     * {@inheritDoc}
     */
    public AdvertisementReview getAdvertisementReviewById(Long advertisementId) {
        return advertisementReviewDao.getAdvertisementReviewById(advertisementId);
    }

}
