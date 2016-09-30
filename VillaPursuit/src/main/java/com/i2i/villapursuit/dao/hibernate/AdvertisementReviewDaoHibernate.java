package com.i2i.villapursuit.dao.hibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.i2i.villapursuit.dao.AdvertisementReviewDao;
import com.i2i.villapursuit.model.Advertisement;
import com.i2i.villapursuit.model.AdvertisementReview;
import com.i2i.villapursuit.model.User;

/**
 * This class interacts with Hibernate session to save/delete and
 * retrieve AdvertisementReview objects.
 *
 * @author Team #3
 */
@Repository("advertisementReviewDao")
@Transactional
public class AdvertisementReviewDaoHibernate extends GenericDaoHibernate<AdvertisementReview, Long> implements AdvertisementReviewDao{
    /**
     * Constructor that sets the entity to Advertisement.class.
     */
    public AdvertisementReviewDaoHibernate() {
        super(AdvertisementReview.class);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<AdvertisementReview> getAdvertisementReviews() {
        return getSession().createQuery("from AdvertisementReview").list();
    }

    /**
     * {@inheritDoc}
     */
    public AdvertisementReview saveAdvertisementReview(AdvertisementReview advertisementReview, Long advertisementId,
            User user) {
        Advertisement advertisement = (Advertisement)getSession().get(Advertisement.class, advertisementId);
        advertisementReview.setAdvertisement(advertisement);
        advertisementReview.setUser(user);
        getSession().saveOrUpdate(advertisementReview);
        return advertisementReview;
    }

    /**
     * {@inheritDoc}
     */
    public void removeAdvertisementReviewById(Long advertisementReviewId) {
        AdvertisementReview advertisementReview = (AdvertisementReview)getSession().get(AdvertisementReview.class, advertisementReviewId);
        getSession().delete(advertisementReview);
    }

    /**
     * {@inheritDoc}
     */
    public AdvertisementReview getAdvertisementReviewById(Long advertisementReviewId) {
        return (AdvertisementReview)getSession().get(AdvertisementReview.class, advertisementReviewId);
    }

}
