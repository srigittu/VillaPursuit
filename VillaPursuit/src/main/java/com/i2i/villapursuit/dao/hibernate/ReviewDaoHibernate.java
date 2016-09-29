package com.i2i.villapursuit.dao.hibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.i2i.villapursuit.dao.ReviewDao;
import com.i2i.villapursuit.exception.VillaPursuitException;
import com.i2i.villapursuit.model.Review;

/**
 * This class interacts with Hibernate session to save/delete and retrieve
 * Review objects.
 *
 * @author Team #3
 */
@Transactional
@Repository("reviewDao")
public class ReviewDaoHibernate extends GenericDaoHibernate<Review, Long> implements ReviewDao {

    /**
     * Constructor that sets the entity to Review.class.
     */
    public ReviewDaoHibernate() {
        super(Review.class);
    }

    /**
     * Method which saves review details into database.
     * 
     * @param review
     *            Contains object of the review database.
     * @throws VillaPursuitException
     *             If there is failed or interrupted when save an advertisement
     *             or when connection fails.
     */
    public Review saveReview(Review review) throws VillaPursuitException {
        try {
            System.out.println("inside add review Dao");
            Session session = getSession();
            session.save(review);
            System.out.println("inside add review Dao");
            return review;
        } catch (HibernateException exceptionCause) {
            throw new VillaPursuitException(
                    "\t\"Error occured while Adding an Review... Please try again...\"" + exceptionCause.toString());
        }
    }

    /**
     * Method which retrieves reviews for a particular advertisement from review
     * database.
     * 
     * @throws VillaPursuitException
     *             If there is failed or interrupted when get all reviews or
     *             when connection fails.
     */
    @SuppressWarnings("unchecked")
    public List<Review> getAdvertisementReviews(Long advertisementId) throws VillaPursuitException {
        try {
            return getSession().createCriteria(Review.class).add(Restrictions.eq("advertisement_id", advertisementId))
                    .list();
        } catch (HibernateException exceptionCause) {
            throw new VillaPursuitException(
                    "\t\"Error occured while Retrieving Reviews... Please try again...\"" + exceptionCause.toString());
        }
    }
}
