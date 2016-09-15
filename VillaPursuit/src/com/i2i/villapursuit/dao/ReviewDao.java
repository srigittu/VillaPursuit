/**
 * @author Team #3
 *
 * @created 12/09/16 
 */
package com.i2i.villapursuit.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.i2i.villapursuit.connection.HibernateConnection;
import com.i2i.villapursuit.exception.VillaPursuitException;
import com.i2i.villapursuit.model.Advertisement;
import com.i2i.villapursuit.model.Review;
import com.i2i.villapursuit.model.User;
public class ReviewDao {
	private SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    private Transaction transaction = null;

    public void insertReview(Review review, int advertisementId, int userId) throws VillaPursuitException {
    	Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            session.save(review);
            Advertisement advertisement = (Advertisement)session.get(Advertisement.class, advertisementId);
            review.setAdvertisement(advertisement);
            User user = (User)session.get(User.class, userId);
            review.setUser(user);
            transaction.commit();
        } catch (HibernateException exceptionCause) {
            if (transaction!=null) {
                transaction.rollback();
            }
            throw new VillaPursuitException("\t\"Error occured while Adding Review... Please try again...\""+exceptionCause.toString());
        } finally {
            session.close(); 
        }
    }

    @SuppressWarnings("unchecked")
	public List<Review> retriveAllReviews() throws VillaPursuitException {
        Session session = sessionFactory.openSession();
        try {
        	return session.createQuery("FROM Review").list();        
        } catch (HibernateException exceptionCause) {
            throw new VillaPursuitException("\t\"Error occured while retriving Reviews... Please try again...\""+exceptionCause.toString());
        } finally {
            session.close(); 
        }
    }
		

}
