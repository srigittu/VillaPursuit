package com.i2i.villapursuit.dao.hibernate;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.i2i.villapursuit.dao.ReviewDao;
import com.i2i.villapursuit.model.Review;

/**
 * This class interacts with Hibernate session to save/delete and
 * retrieve Review objects.
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
     * @param review
     *            Contains object of the review database.
     */
	public Review saveReview(Review review) {
		System.out.println("inside add review Dao");
		Session session = getSession();
		session.save(review);
		System.out.println("inside add review Dao");
		return review;
	}
}
