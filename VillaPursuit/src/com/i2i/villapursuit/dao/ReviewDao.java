// Copyright (C) 2015 Ideas2IT, Inc.
// All rights reserved

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

/**
 * <p>
 * Dao which performs operations on Review database 
 * according to URL mapping
 * </p>
 * 
 * @author Team #3
 * 
 * @created 07/09/16
 */
public class ReviewDao {
    private SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
    private Transaction transaction = null;
    
    /**
     * <p>
     * Method which fetches request from service.
     * Insert review details into database.
     * </p>
     * @param review
     *     Contains object of the review model.
     * @param advertisementId
     *     Contains advertisement Id.
     * @param userId
     *     Contains User Id.
     * @throws VillaPursuitException
     *     If there is failed or interrupted database operations.
     */
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
    
    /**
     * <p>
     * Method which fetches request from service.
     * Retrieve all user details from database.
     * </p>
     * @return users
     *     Return all list of user.
     * @throws VillaPursuitException
     *     If there is failed or interrupted database operations.
     */
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
